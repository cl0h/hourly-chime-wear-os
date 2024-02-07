package com.cl0h.hourlychime

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.VibrationEffect
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        // Implement the logic to play the chime here.
        //Vibrate
        VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE)
        //Chime
        RingtoneManager.getRingtone(
            context,
            RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        ).play()
        //Play something
        MediaPlayer.create(context, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM))
            .start()
        //log the time of the chime
        Log.d("AlarmReceiver", "Chime at ${System.currentTimeMillis()}")
    }
}
