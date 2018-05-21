package test;
import org.junit.Assert;
import org.junit.Test;
import tech._1379.ZipCodeRangeList;

public class MainTest {
    @Test
    // test a known good string to pass regex
    public void testIsValidInputSuccess() {
        boolean response = tech._1379.Main.isValidInput("[12345,12345] [23456,23456] [95811] [95816]");

        Assert.assertEquals(response, true);
    }

    @Test
    // Test a known bad string that should not pass regex
    public void testIsValidInputFail() {
        boolean response = tech._1379.Main.isValidInput("bad string");

        Assert.assertEquals(response, false);
    }

    @Test
    // Test a known good case with a string
    public void testParseInputValid() {
        ZipCodeRangeList response = tech._1379.Main.parseInput("[12345,12345] [23456,23457] [95811,95816]");

        Assert.assertEquals(response.getLength(), 3);
        Assert.assertEquals((response.getElementAtIndex(0).getStart()), 12345);
        Assert.assertEquals((response.getElementAtIndex(0).getEnd()), 12345);
        Assert.assertEquals((response.getElementAtIndex(1).getStart()), 23456);
        Assert.assertEquals((response.getElementAtIndex(1).getEnd()), 23457);
        Assert.assertEquals((response.getElementAtIndex(2).getStart()), 95811);
        Assert.assertEquals((response.getElementAtIndex(2).getEnd()), 95816);
    }

    @Test
    // Test a known invalid case where the string would still pass the regular expression of isValid
    public void testParseInputFailInvalid() {
        ZipCodeRangeList response = tech._1379.Main.parseInput("[,] [95811] [,,,] 95811 ][ [] [123,456]");

        Assert.assertEquals(response.getLength(), 0);
    }
}
