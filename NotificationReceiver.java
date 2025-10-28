package com.example.student_mate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        com.example.student_mate.notification.NotificationHelper.showReminder(context, "Hora de revisar!", "Abra o Student Mate e revise os seus flashcards.");
    }
}