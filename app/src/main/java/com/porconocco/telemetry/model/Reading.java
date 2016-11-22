package com.porconocco.telemetry.model;

public class Reading
{
    public Reading(final String name, final Double value, final String units)
    {
        this.name = name;
        this.value = value;
        this.units = units;
    }

    final String name;
    final Double value;
    final String units;

    public static Reading getNotAvailableReading()
    {
        return new Reading("n/a", 0.0, "n/a");
    }
}
