package be.pxl.JUnit;

/**
 * Created by tim_v on 21/02/2017.
 */
public class Temperature
{
    private long temp;

    public Temperature(float temperature)
    {
        this.temp = (long) temperature;
    }

    public long getTemp() {
        return temp;
    }

    public void setTemp(long temp) {
        this.temp = temp;
    }

    public boolean isBoiling()
    {
        return (temp >= 100);
    }

    public boolean isFreezing()
    {
        return (temp <= 0);
    }

    public boolean equals(Object o)
    {
        return false;
    }

    public int hashCode()
    {
        return 0;
    }
}
