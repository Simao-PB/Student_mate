package com.example.student_mate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FlashcardAdapter extends RecyclerView.Adapter<FlashcardAdapter.VH> {

    public void setFlashcards(List<Flashcard> data) {
        list = data;
        notifyDataSetChanged();
    }


    interface OnCardClick { void onClick(Flashcard card); }
    private List<Flashcard> list = new ArrayList<>();
    private OnCardClick callback;
    private Context ctx;

    public FlashcardAdapter(Context ctx, OnCardClick cb) {
        this.ctx = ctx;
        this.callback = cb;
    }

    public void setFlashcards(Object data) {
        list = (List<Flashcard>) data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(ctx).inflate(R.layout.item_flashcard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Flashcard f = list.get(position);
        holder.tvQuestion.setText(f.question);
        holder.tvTopic.setText(f.topic == null ? "Geral" : f.topic);
        holder.itemView.setOnClickListener(v -> {
            if (callback != null) callback.onClick(f);
        });
        holder.itemView.setOnLongClickListener(v -> {
            Toast.makeText(ctx, "Revisões: " + f.reviewsCount, Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    @Override
    public int getItemCount() { return list.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvQuestion, tvTopic;
        VH(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tv_question);
            tvTopic = itemView.findViewById(R.id.tv_topic);
        }
    }
}