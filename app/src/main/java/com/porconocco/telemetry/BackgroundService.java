package com.porconocco.telemetry;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class BackgroundService
    extends Service
{
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onCreate()
    {
        Toast.makeText(this, "Telemetry service created", Toast.LENGTH_LONG).show();

        handler = new Handler();
        runnable = new Runnable()
        {
            public void run()
            {
                Toast.makeText(context, "Fresh telemetry", Toast.LENGTH_LONG).show();
                handler.postDelayed(runnable, 5000);
            }
        };

        handler.postDelayed(runnable, 5000);
    }

    @Override
    public void onDestroy()
    {
        Toast.makeText(this, "Telemetry service destroyed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startid)
    {
    }

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;
}
