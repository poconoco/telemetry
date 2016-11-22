package com.porconocco.telemetry.impl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.porconocco.telemetry.model.IReadingProvider;
import com.porconocco.telemetry.model.Reading;

public class TemperatureProvider
    implements IReadingProvider
{
    TemperatureProvider(final Context context)
    {
        _sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        _temperature = _sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    @Override
    public boolean isAvailable()
    {
        return _temperature != null;
    }

    @Override
    public void oneShot(final Listener listener)
    {
        if (_temperature == null)
        {
            listener.onReading(Reading.getNotAvailableReading());
            return;
        }

        _sensorManager.registerListener(
            new SensorEventListener()
                {
                    @Override
                    public void onSensorChanged(SensorEvent sensorEvent)
                    {
                        listener.onReading(toReading(sensorEvent));
                        _sensorManager.unregisterListener(this);
                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int i)
                    {}
                },
            _temperature,
            SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void startUpdates(final Listener listener, long periodSeconds)
    {
        throw new RuntimeException("periodic updates are not implemented");
    }

    @Override
    public void stopUpdates(final Listener listener)
    {
        throw new RuntimeException("periodic updates are not implemented");
    }

    private Reading toReading(final SensorEvent event)
    {
        return new Reading("Temperature", Double.valueOf(event.values[0]), "°C");
    }

    private final SensorManager _sensorManager;
    private Sensor _temperature;
}
