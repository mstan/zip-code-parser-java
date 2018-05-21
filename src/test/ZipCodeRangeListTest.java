package test;

import org.junit.Assert;
import org.junit.Test;
import tech._1379.ZipCodeRange;
import tech._1379.ZipCodeRangeList;

public class ZipCodeRangeListTest {
    private ZipCodeRangeList zipCodeRangeList = new ZipCodeRangeList();

    @Test
    public void testAdd() {
        ZipCodeRange zipCodeRange = new ZipCodeRange(12345,23456);
        zipCodeRangeList.add(zipCodeRange);

        Assert.assertEquals(zipCodeRangeList.getLength(), 1);
    }

    @Test
    public void testSet() {
        zipCodeRangeList = new ZipCodeRangeList();
        Assert.assertEquals(zipCodeRangeList.getLength(), 0);
    }

    @Test
    public void testPrint() {
        zipCodeRangeList.add(new ZipCodeRange(95811,95816));
        zipCodeRangeList.print();
    }

    @Test
    public void testCollapse() {
        zipCodeRangeList.add(new ZipCodeRange(95811,95816));
        zipCodeRangeList.add(new ZipCodeRange(95816,95825));
        zipCodeRangeList.add(new ZipCodeRange(95826,95826));

        zipCodeRangeList.collapse();

        Assert.assertEquals(zipCodeRangeList.getLength(), 2);
    }

    @Test
    public void testSortAscending() {
    //@TODO
    }

    @Test
    public void testOrder() {
    //@TODO
    }
}
