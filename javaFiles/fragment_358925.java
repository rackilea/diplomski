import java.util.Arrays;  // Maybe all of your problem is that you had typo in import?
// This is language standard stuff, available everywhere IMHO

    /**
     * Removes duplicates and nulls from sorted array, first item (sortedArray[i][0]) is considered
     * for duplicates search, rest of values sortedArray[i][1..n] is not considered at all.
     * 
     * @param sortedArray
     *            sorted 2D String array, can have any 1 <= length in second dimension.
     * @return items with duplicate in [i][0] or null will be removed from result array.
     */
    public static String[][] removeDuplicateOrNullItems(final String[][] sortedArray) {
        // validate input
        if (null == sortedArray || sortedArray.length <= 1) {
            return sortedArray; // garbage in, garbage out
        }
        // search for first duplicate (if any)
        int i = 0;
        while (++i < sortedArray.length) {
            if (null == sortedArray[i][0] || sortedArray[i][0].equals(sortedArray[i - 1][0])) {
                break;
            }
        }
        if (i == sortedArray.length) {
            return sortedArray; // no duplicate found, return input
        }
        // First duplicate is at index i, now compact the rest of array content (overwriting dupes)
        int newi = i; // will serve both as count of unique values, and compact-writing index
        while (++i < sortedArray.length) {
            if (null == sortedArray[i][0] || sortedArray[i][0].equals(sortedArray[i - 1][0])) {
                continue; // another duplicate, skip this one
            }
            sortedArray[newi++] = sortedArray[i]; // valid value, compact it
        }
        return Arrays.copyOf(sortedArray, newi); // return the compacted result
    }

// demo how to call it:

        String[][] in = {{"A1", "A2"}, {"A1", "dupA"}, {null, null}, {"B1", "B2"}, {"B1", "dupB1"}, {"B1", "dupB2"}, {"C1", "C2"}};
//      String[][] in = {{"A1", "A2", "A3"}, {"B1", "B2", "B3"}};
//      String[][] in = null;

        String[][] out = removeDuplicateOrNullItems(in);