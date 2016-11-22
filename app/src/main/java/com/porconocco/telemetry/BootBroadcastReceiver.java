package com.porconocco.telemetry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootBroadcastReceiver
    extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "BOOT RECEIVED", Toast.LENGTH_LONG).show();
/*        Intent myIntent = new Intent(context, BackgroundService.class);
        context.startService(myIntent);*/
    }
}
