package com.example.student_mate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Simples receiver que poderia re-agendar alarmes após reboot.
// (Reagendar lógica extra seria adicionada aqui se necessário.)
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Placeholder — se tiver alarmes persistidos, re-agende-os aqui.
        // Exemplo: AlarmUtils.scheduleReviewForAll(context, someStoredTime);
    }
}