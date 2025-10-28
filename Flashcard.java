package com.example.student_mate;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "flashcards")
public class Flashcard {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public int reviewsCount;
    public String question;
    public String answer;
    public long lastReviewed;
    public String topic;

    public Flashcard() {} // construtor vazio necessário para Room
}
