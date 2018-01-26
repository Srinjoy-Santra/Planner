package com.example.newu.planner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.provider.AlarmClock;

/**
 * Created by nEW u on 20-Jun-17.
 */

public class BackgroundProcess extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(3000);


    }
}