package com.example.student_mate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student_mate.data.AppDatabase;
import com.example.student_mate.data.FlashcardDao;


import androidx.appcompat.app.AppCompatActivity;

import com.example.student_mate.Flashcard;
import com.example.student_mate.data.FlashcardDao;

import java.util.Calendar;
import java.util.List;

public class CronogramActivity extends AppCompatActivity {
    Button btnScheduleAll, btnPick;
    TextView tvNext;
    FlashcardDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronogram);
        dao = AppDatabase.getInstance(getApplicationContext()).flashcardDao();

        btnScheduleAll = findViewById(R.id.btn_schedule_all);
        btnPick = findViewById(R.id.btn_pick_time);
        tvNext = findViewById(R.id.tv_next_time);

        btnPick.setOnClickListener(v -> pickDateTime());
        btnScheduleAll.setOnClickListener(v -> scheduleAll());

        loadNextScheduled();
    }

    private void pickDateTime() {
        final Calendar c = Calendar.getInstance();
        DatePickerDialog dp = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            TimePickerDialog tp = new TimePickerDialog(this, (view1, hourOfDay, minute) -> {
                Calendar sel = Calendar.getInstance();
                sel.set(year, month, dayOfMonth, hourOfDay, minute, 0);
                long when = sel.getTimeInMillis();
                tvNext.setText("Agendado para: " + sel.getTime().toString());
                com.example.student_mate.notification.AlarmUtils.scheduleReviewForAll(this, when);
            }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true);
            tp.show();
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        dp.show();
    }

    private void scheduleAll() {
        // schedule reviews for next day at 9:00 as a simple default
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, 1);
        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        com.example.student_mate.notification.AlarmUtils.scheduleReviewForAll(this, c.getTimeInMillis());
        Toast.makeText(this, "Revisões agendadas para amanhã 9:00", Toast.LENGTH_SHORT).show();
    }

    private void loadNextScheduled() {
        // For demo, show number of cards due (simple heuristic)
        AsyncTask.execute(() -> {
            List<Flashcard> all = dao.getAll();
            long now = System.currentTimeMillis();
            int due = (int) all.stream().filter(f -> f.lastReviewed == 0 || now - f.lastReviewed > 24L * 60 * 60 * 1000).count();
            // consider due if never reviewed or lastReviewed older than 24h
            runOnUiThread(() -> tvNext.setText("Cartões pendentes: " + due));
        });
    }
}