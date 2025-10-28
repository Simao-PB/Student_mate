package com.example.student_mate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    Button btnFlashcards, btnCronogram, btnStatics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFlashcards = findViewById(R.id.btn_flashcards);
        btnCronogram = findViewById(R.id.btn_cronogram);
        btnStatics = findViewById(R.id.btn_statics);

        btnFlashcards.setOnClickListener(v -> startActivity(new Intent(this, FlashcardsActivity.class)));
        btnCronogram.setOnClickListener(v -> startActivity(new Intent(this, CronogramActivity.class)));
        btnStatics.setOnClickListener(v -> startActivity(new Intent(this, StaticsActivity.class)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // Menu: alternar tema (escuro/claro) e modo foco (simples)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_toggle_theme) {
            int current = AppCompatDelegate.getDefaultNightMode();
            if (current == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            return true;
        } else if (item.getItemId() == R.id.menu_focus_mode) {
            // Modo foco: abre Flashcards no modo de foco (extra simples)
            Intent intent = new Intent(this, FlashcardsActivity.class);
            intent.putExtra("focus_mode", true);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}