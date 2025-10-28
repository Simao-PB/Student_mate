package com.example.student_mate;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.student_mate.data.AppDatabase;
import com.example.student_mate.data.FlashcardDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticsActivity extends AppCompatActivity {
    TextView tvStats;
    ProgressBar pb;
    FlashcardDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statics);
        tvStats = findViewById(R.id.tv_stats);
        pb = findViewById(R.id.progress_topic);
        dao = AppDatabase.getInstance(getApplicationContext()).flashcardDao();
        loadStats();
    }

    private void loadStats() {
        AsyncTask.execute(() -> {
            List<Flashcard> all = dao.getAll();
            Map<String, Integer> total = new HashMap<>();
            Map<String, Integer> reviewed = new HashMap<>();
            for (Flashcard f : all) {
                String t = (f.topic == null || f.topic.isEmpty()) ? "Geral" : f.topic;
                total.put(t, total.getOrDefault(t, 0) + 1);
                if (f.reviewsCount > 0)
                    reviewed.put(t, reviewed.getOrDefault(t, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            for (String t : total.keySet()) {
                int tot = total.get(t);
                int rev = reviewed.getOrDefault(t, 0);
                int pct = (int) ((rev / (float) tot) * 100);
                sb.append(t).append(": ").append(rev).append("/").append(tot)
                        .append(" (").append(pct).append("%)").append("\n");
            }

            final String out = sb.toString();
            final int overallPct = computeOverallPercent(total, reviewed);
            runOnUiThread(() -> {
                tvStats.setText(out.isEmpty() ? "Sem dados" : out);
                pb.setProgress(overallPct);
            });
        });
    }

    private int computeOverallPercent(Map<String, Integer> total, Map<String, Integer> reviewed) {
        int totAll = 0, revAll = 0;
        for (String t : total.keySet()) {
            totAll += total.get(t);
            revAll += reviewed.getOrDefault(t, 0);
        }
        if (totAll == 0) return 0;
        return (int) ((revAll / (float) totAll) * 100);
    }
}
