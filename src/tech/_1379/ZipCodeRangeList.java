package tech._1379;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZipCodeRangeList {
    private List<ZipCodeRange> zipCodeRangeList = new ArrayList<>();

    // in lieu of conventional getters and setters, we have extended ArrayList and will use ArrayList's functions
    // for our operations

    // -- functions --//
    public void add(ZipCodeRange zipCodeRange) {
        zipCodeRangeList.add(zipCodeRange);
    }

    public int getLength() {
        return zipCodeRangeList.size();
    }

    public void set(List<ZipCodeRange> zipCodeRangeList) {
        this.zipCodeRangeList = zipCodeRangeList;
    }



    // prints out the final result to console in a neatly formatted string
    public void print() {
        String output = "";
        for(int i = 0; i < this.zipCodeRangeList.size() ; i++ ) {
            output += ( "[" + this.zipCodeRangeList.get(i).getStart() + "," + this.zipCodeRangeList.get(i).getEnd() + "] " );
        }
        System.out.print(output);
    }

    // once these are sorted, we need to collapse redundancies. We will do so by pushing the first element to
    // a new collapsed list. Then, if collapsedList's length > 0 &&
    // if the end of collapsedList is >= zipCodeRangeList[i].start,
    // we will set collapsedList's last element's end to zipCodeRangeList[i's end.
    // Otherwise, if collapsedList[i]'s end is < zipCodeRangeList[i]'s start, we will push zipCodeRangeList[i] to collapsedList.
    public void collapse() {
        List<ZipCodeRange> collapsedZipCodeRangeList = new ArrayList<>();

        for( int i = 0; i < this.zipCodeRangeList.size(); i++ ) {
            //if no elements are in arrayToReturn, add the first available element
            // from zipCodeRangeList to start our process
            if(collapsedZipCodeRangeList.size() == 0) {
                collapsedZipCodeRangeList.add(this.zipCodeRangeList.get(i) );
                continue;
            }

            // if collapsedZipCodeRangeList's last element's end is greater than the current zipCodeRangeList[i]'s end
            if( (collapsedZipCodeRangeList.get( collapsedZipCodeRangeList.size() - 1 ).getEnd() ) >= ( this.zipCodeRangeList.get(i).getStart()) ) {

                collapsedZipCodeRangeList.get( collapsedZipCodeRangeList.size() - 1).setEnd( this.zipCodeRangeList.get(i).getStart() );
            } else {
                // if collapsedZipCodeRangeList's last element's endRange is not greater than the current, push the whole
                // zipCodeRangeList[i] to collapsedZipCodeRangeList.
                collapsedZipCodeRangeList.add( this.zipCodeRangeList.get(i) );
            }
        }

        this.set(collapsedZipCodeRangeList);

    }

    // sort zipCodeRangeList in ascending order, ordering by zipCodeRange.start] as the value to sort by
    public void sortAscending() {
        Collections.sort(zipCodeRangeList);
    }

    // order each zipCodeRange's start and end to ensure that each pair is positive.
    // (e.g.) [95816,95811] would be switched to [95811,95816].
    // [95825,94040] would remain the same.
    public void order() {
        for (int i = 0; i < this.zipCodeRangeList.size(); i++) {
            int startRange = this.zipCodeRangeList.get(i).getStart();
            int endRange = this.zipCodeRangeList.get(i).getEnd();

            if (startRange > endRange) {
                this.zipCodeRangeList.set(i, new ZipCodeRange(startRange, endRange));
            }
        }
    }
}
