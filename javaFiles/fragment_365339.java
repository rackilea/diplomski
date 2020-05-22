public class QuickSortTest {
    private static String[] data = new String[] {"a", "b", "c", "f", "b", "e", "b"};

    public static void main(String[] args) {
        String[] sortedData = quickSort(data);
        for (String str : sortedData) {
            System.out.println(str);
        }
    }

    private static String[] quickSort(String[] data) {
        // Edge case: return just the data if there are 0 or 1 elements (already sorted)
        if (data.length <= 1) {
            return data;
        }

        // Initialize the return structure
        String[] sortedData = new String[data.length];

        // Choose the pivot (can be any value)
        String pivot = data[data.length - 1];

        // Initialize the bins
        ArrayList<String> lessThan = new ArrayList<String>();
        ArrayList<String> equalTo = new ArrayList<String>();
        ArrayList<String> greaterThan = new ArrayList<String>();

        // Place the data into bins (based on the pivot)
        for (String str : data) {
            int compareValue = str.compareTo(pivot);
            if (compareValue < 0) {
                lessThan.add(str);
            }
            else if (compareValue > 0) {
                greaterThan.add(str);
            }
            else {
                equalTo.add(str);
            }
        }

        // Sort the non-equal data
        String[] lessThanSorted = quickSort(lessThan.toArray(new String[0]));
        String[] greaterThanSorted = quickSort(greaterThan.toArray(new String[0]));

        // Merge the data
        int length = 0;
        for (String less : lessThanSorted) {
            sortedData[length++] = less;
        }
        for (String equal : equalTo) {
            sortedData[length++] = equal;
        }
        for (String greater : greaterThanSorted) {
            sortedData[length++] = greater;
        }

        return sortedData;
    }
}