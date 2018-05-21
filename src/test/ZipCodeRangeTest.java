package test;
import tech._1379.ZipCodeRange;

import org.junit.Test;
import org.junit.Assert;

public class ZipCodeRangeTest {

    @Test
    public void testGetStart() {
        ZipCodeRange zipCodeRange = new ZipCodeRange(12345,67890);
        int start = zipCodeRange.getStart();

        Assert.assertEquals(start, 12345);
    }

    @Test
    public void testGetEnd() {
        ZipCodeRange zipCodeRange = new ZipCodeRange(12345,67890);
        int end = zipCodeRange.getEnd();

        Assert.assertEquals(end, 67890);
    }

    @Test
    public void testSetStart() {
        ZipCodeRange zipCodeRange = new ZipCodeRange(12345,67890);
        zipCodeRange = zipCodeRange.setStart(12346);
        int start = zipCodeRange.getStart();
        Assert.assertEquals(start,12346);
    }

    @Test
    public void testSetEnd() {
        ZipCodeRange zipCodeRange = new ZipCodeRange(12345,67890);
        zipCodeRange = zipCodeRange.setStart(12346);
        int start = zipCodeRange.getStart();
        Assert.assertEquals(start,12346);
    }

    // compareTo is used in the ZipCodeRangeList for it's Collections sort. The unit test is to be implemented there
}
