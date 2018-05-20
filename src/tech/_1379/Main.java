package tech._1379;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    // take a string and try to parse it into a ZipCodeRangeList. Regular expressions are used to look for something
    // in the format of [#####,#####][#####,#####]...[#####,#####]
    private static ZipCodeRangeList parseInput(String input) {
        // declare a list of ZipCodeRange
        ZipCodeRangeList zipCodeRangeList = new ZipCodeRangeList();

        // define  a pattern of [#####,#####] that should exist an indefinite number of times
        // then, try this against a trimmed version of the input (no spaces).
        Pattern pattern = Pattern.compile("\\[([0-9]{5}),([0-9]{5})\\]");
        Matcher matcher = pattern.matcher(input.trim());

        // while matcher is going through and finding matched instances, push each to the zipCodeRanges array.
        while (matcher.find() ) {
            int startRange = Integer.parseInt(matcher.group(1));
            int endRange = Integer.parseInt(matcher.group(2));
            //push each instance that resembles our desired pattern
            zipCodeRangeList.add(new ZipCodeRange(startRange,endRange));
        }

        return zipCodeRangeList;
    }

    // checks to see if the input is valid based on a regular expression
    private static boolean isValidInput(String string) {
        // pattern checks to see if the value only contains numbers, spaces, "," "]" or "["
        String pattern = "^[\\[\\], \\pN]+$";
        return string.matches(pattern);
    }

    // primary input function
    public static void main(String[] args) {
        System.out.println("Enter a range of zip code ranges. (ex: [62864,62864] [95811,95816] [95816,94040])");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        // while the expected input is not valid, keep asking the user
        while( !isValidInput(input) ) {
            System.out.println("Input was invalid. Please try again");
            input = scanner.nextLine();
        }

        // parses the input and returns a list of 2-element integer arrays.
        ZipCodeRangeList zipCodeRangeList = parseInput(input);
        // ensure for each element in zipCodeRanges that startRange < endRange.
        // For all cases where this is not true, reverse the startRange and endRange

        // There are many additional sanity checks that could be done. For instance, we could build a check into
        // the constructors. However, this adds many complexities such as having to perform logic checks on setting
        // new starts and ends. For sake of simplicity in this application and to try and keep it intuitive
        // for the end user, we just perform this check here
        zipCodeRangeList.order();
        // now at this point, we need to sort zipCodeRanges in ascending order, using the starting element[0] as
        // what we are sorting by.
        zipCodeRangeList.sortAscending();
        // collapse redundant ranges
        zipCodeRangeList.collapse();
        // prints out the final result in a nice neat string
        zipCodeRangeList.print();

    }
}
