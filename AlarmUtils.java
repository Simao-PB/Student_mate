package com.example.student_mate.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.example.student_mate.NotificationReceiver;

public class AlarmUtils {
    public static void scheduleReviewForAll(Context ctx, long whenMillis) {
        AlarmManager am = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(ctx, NotificationReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(ctx, 2002, i, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);
        if (am != null) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, whenMillis, pi);
            } else {
                am.setExact(AlarmManager.RTC_WAKEUP, whenMillis, pi);
            }
        }
    }
}