package test;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void testParseInputSuccess() {
        boolean response = tech._1379.Main.isValidInput("[12345,12345] [23456,23456] [95811] [95816]");

        Assert.assertEquals(response, true);
    }

    @Test
    public void testParseInputFailString() {
        boolean response = tech._1379.Main.isValidInput("bad string");

        Assert.assertEquals(response, false);
    }
}
