package com.example.student_mate.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;

import com.example.student_mate.MainActivity;
import com.example.student_mate.R;

public class NotificationHelper {
    private static final String CHANNEL_ID = "student_mate_channel";

    public static void showReminder(Context ctx, String title, String body) {
        NotificationManager nm = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        if (nm == null) return;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel ch = new NotificationChannel(CHANNEL_ID, "Student Mate", NotificationManager.IMPORTANCE_DEFAULT);
            ch.setDescription("Notificações de revisão");
            ch.enableLights(true);
            ch.setLightColor(Color.BLUE);
            nm.createNotificationChannel(ch);
        }
        Intent i = new Intent(ctx, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(ctx, 0, i, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder nb = new NotificationCompat.Builder(ctx, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pi)
                .setAutoCancel(true);
        nm.notify(1001, nb.build());
    }
}