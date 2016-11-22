package com.porconocco.telemetry.model;

public interface IReadingProvider
{
    interface Listener
    {
        void onReading(Reading reading);
    }

    boolean isAvailable();
    void oneShot(Listener listener);

    void startUpdates(Listener listener, long periodSeconds);
    void stopUpdates(Listener listener);
}
