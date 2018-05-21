package tech._1379;

public class ZipCodeRange implements Comparable<ZipCodeRange> {
    private int start;
    private int end;

    // default constructor
    public ZipCodeRange() {
        this.start = 0;
        this.end = 0;
    }

    public ZipCodeRange(ZipCodeRange zipCodeRange) {
        this.start = zipCodeRange.start;
        this.end = zipCodeRange.end;
    }

    public ZipCodeRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    //-- Getters --//

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    //-- Setters --//

    public ZipCodeRange setStart(int start) {
        this.start = start;
        return this;
    }
    public ZipCodeRange setEnd(int end) {
        this.end = end;
        return this;
    }

    // -- Functions -- //
    public int compareTo(ZipCodeRange zipCodeRange) {
        if( this.start > zipCodeRange.start ) {
            return 1;
        }

        if( this.start < zipCodeRange.start) {
            return -1;
        }
        // They are equal
        return 0;
    }
}
