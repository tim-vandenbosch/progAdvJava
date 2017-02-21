package be.pxl.JUnit;
import org.junit.*;

import static org.junit.Assert.*;


/**
 * Created by tim_v on 21/02/2017.
 */
public class TemperatureTest
{
    @Test
    public void testConstructor()
    {
        new Temperature(10);
    }

    @Test
    public void testValue()
    {
        // test getters and setter
        Temperature temp;
        temp = new Temperature(10);
        temp.setTemp(10);
        long gottenTemp = temp.getTemp();

        assertEquals(10,gottenTemp);
    }

    @Test
    public void testEquals()
    {
        fail();
    }

    @Test
    public void testHashCode()
    {
        fail();
    }
}
