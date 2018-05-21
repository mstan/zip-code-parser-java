package test;
import org.junit.Before;
import org.junit.BeforeClass;
import tech._1379.ZipCodeRange;

import org.junit.Test;
import org.junit.Assert;

public class ZipCodeRangeTest {
    private ZipCodeRange zipCodeRange = new ZipCodeRange(12345,67890);

    @Test
    public void testGetStart() {
        int start = zipCodeRange.getStart();

        Assert.assertEquals(start, 12345);
    }

    @Test
    public void testGetEnd() {
        int end = zipCodeRange.getEnd();

        Assert.assertEquals(end, 67890);
    }

    @Test
    public void testSetStart() {
        zipCodeRange = zipCodeRange.setStart(12346);
        int start = zipCodeRange.getStart();
        Assert.assertEquals(start,12346);
    }

    @Test
    public void testSetEnd() {
        zipCodeRange = zipCodeRange.setStart(12346);
        int start = zipCodeRange.getStart();
        Assert.assertEquals(start,12346);
    }

    // compareTo is used in the ZipCodeRangeList for it's Collections sort. The unit test is to be implemented
    // there
}
