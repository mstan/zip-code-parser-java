package test;

import org.junit.Assert;
import org.junit.Test;
import tech._1379.ZipCodeRange;
import tech._1379.ZipCodeRangeList;

public class ZipCodeRangeListTest {
    @Test
    public void testAdd() {
        ZipCodeRangeList zipCodeRangeList = new ZipCodeRangeList();
        ZipCodeRange zipCodeRange = new ZipCodeRange(12345,23456);
        zipCodeRangeList.add(zipCodeRange);

        Assert.assertEquals(zipCodeRangeList.getLength(), 1);
    }

    @Test
    public void testSet() {
        ZipCodeRangeList zipCodeRangeList = new ZipCodeRangeList();
        zipCodeRangeList = new ZipCodeRangeList();
        Assert.assertEquals(zipCodeRangeList.getLength(), 0);
    }

    @Test
    public void testPrint() {
        ZipCodeRangeList zipCodeRangeList = new ZipCodeRangeList();
        zipCodeRangeList.add(new ZipCodeRange(95811,95816));
        zipCodeRangeList.print();
    }

    @Test
    // reduce any redundancies in our ZipCodeRangeList.
    public void testCollapse() {
        ZipCodeRangeList zipCodeRangeList = new ZipCodeRangeList();
        zipCodeRangeList.add(new ZipCodeRange(95811,95816));
        zipCodeRangeList.add(new ZipCodeRange(95816,95825));
        zipCodeRangeList.add(new ZipCodeRange(95826,95826));

        zipCodeRangeList.collapse();

        Assert.assertEquals(zipCodeRangeList.getLength(), 2);
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(0).getStart(), 95811);
        // TODO
        // this unit test case of the last element of the first index is not properly assigning.
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(0).getEnd(), 95825);
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(1).getStart(), 95826);
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(1).getEnd(), 95826);
    }

    @Test
    // sorts all elements in ZipCodeRangeList in ascending order of their start range
    public void testSortAscending() {
        ZipCodeRangeList zipCodeRangeList = new ZipCodeRangeList();
        zipCodeRangeList.add(new ZipCodeRange(95816,95825));
        zipCodeRangeList.add(new ZipCodeRange(95826,95826));
        zipCodeRangeList.add(new ZipCodeRange(95811,94040));

        zipCodeRangeList.sortAscending();

        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(0).getStart(), 95811);
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(1).getStart(), 95816);
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(2).getStart(), 95826);
    }

    @Test
    // for each ZipCodeRange in ZipCodeRangeList, order them such that start <= end
    public void testOrder() {
        ZipCodeRangeList zipCodeRangeList = new ZipCodeRangeList();
        zipCodeRangeList.add(new ZipCodeRange(95811,62864));
        zipCodeRangeList.add(new ZipCodeRange(95816,95816));
        zipCodeRangeList.add(new ZipCodeRange(95825,94040));

        zipCodeRangeList.order();

        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(0).getStart(), 62864);
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(1).getStart(), 95816);
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(2).getStart(), 94040);

        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(0).getEnd(), 95811);
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(1).getEnd(), 95816);
        Assert.assertEquals(zipCodeRangeList.getElementAtIndex(2).getEnd(), 95825);
    }
}
