package com.example.student_mate;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.student_mate.data.AppDatabase;
import com.example.student_mate.data.FlashcardDao;

import java.util.List;

public class FlashcardsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FlashcardAdapter adapter;
    ImageButton btnAdd;
    FlashcardDao dao;
    boolean focusMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);

        dao = AppDatabase.getInstance(getApplicationContext()).flashcardDao();

        recyclerView = findViewById(R.id.recycler_flashcards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FlashcardAdapter(this, this::showCardOptions);
        recyclerView.setAdapter(adapter);

        btnAdd = findViewById(R.id.btn_add_card);

        focusMode = getIntent().getBooleanExtra("focus_mode", false);
        if (focusMode) {
            btnAdd.setVisibility(View.GONE);
            getSupportActionBar().hide();
        }

        btnAdd.setOnClickListener(v -> showAddDialog());

    }



    private void showAddDialog() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Novo Flashcard");
        View v = getLayoutInflater().inflate(R.layout.dialog_add_card, null);

        EditText etQuestion = v.findViewById(R.id.et_question);
        EditText etAnswer = v.findViewById(R.id.et_answer);
        EditText etTopic = v.findViewById(R.id.et_topic);
        b.setView(v);

        b.setPositiveButton("Criar", (dialog, which) -> {
            String q = etQuestion.getText().toString().trim();
            String a = etAnswer.getText().toString().trim();
            String t = etTopic.getText().toString().trim();

            if (q.isEmpty() || a.isEmpty()) {
                Toast.makeText(this, "Pergunta e resposta são obrigatórias", Toast.LENGTH_SHORT).show();
                return;
            }

            Flashcard card = new Flashcard();
            card.question = q;
            card.answer = a;
            card.topic = t.isEmpty() ? "Geral" : t;

            AsyncTask.execute(() -> dao.insert(card));
        });

        b.setNegativeButton("Cancelar", null);
        b.show();
    }

    private void showCardOptions(Flashcard card) {
        String[] opts = new String[]{"Ver resposta", "Marcar como revisado hoje", "Eliminar"};
        new AlertDialog.Builder(this)
                .setTitle(card.question)
                .setItems(opts, (dialog, which) -> {
                    if (which == 0) {
                        new AlertDialog.Builder(this)
                                .setMessage(card.answer)
                                .setPositiveButton("OK", null)
                                .show();
                    } else if (which == 1) {
                        AsyncTask.execute(() -> {
                            card.lastReviewed = System.currentTimeMillis();
                            card.reviewsCount += 1;
                            dao.update(card);
                        });
                    } else if (which == 2) {
                        AsyncTask.execute(() -> dao.delete(card));
                    }
                })
                .show();
    }
}
