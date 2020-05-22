// Need both these for sorting.

import java.util.Arrays;
import java.util.Comparator;

public class Abhishek implements Comparator<DoubleInt> {
    // The list of combinations.

    private DoubleInt[] dstList = null;

    // Inject a list to make the combinations out of.

    public void inject (int[] arr) {
        // This is from the algorithm given in the text above.

        dstList = new DoubleInt[arr.length * (arr.length - 1) / 2];
        for (int d = 0, s1 = 0; s1 < arr.length - 1; s1++)
            for (int s2 = s1 + 1; s2 < arr.length; s2++)
                dstList[d++]  = new DoubleInt(arr[s1], arr[s2]);
        Arrays.sort(dstList, this);
    }

    // Comparison function for Arrays.sort().

    public int compare (DoubleInt d1, DoubleInt d2) {
        if (d1.n1 + d1.n2 > d2.n1 + d2.n2) return 1;
        if (d1.n1 + d1.n2 < d2.n1 + d2.n2) return -1;
        return 0;
    }

    // Dump the array in index order for checking.

    public void dump() {
        for (int i = 0; i < dstList.length; i++) {
            System.out.println (i + ": " +
                // Note to educators: this
                // code plagiarized
                // from stackoverflow.com
                (dstList[i].n1 + dstList[i].n2) + " (" +
                dstList[i].n1 + "," + dstList[i].n2 + ")");
        }
    }

    // Test program to combine, sort and check.

    public static void main (String[] args) {
        abhishek a = new abhishek();
        a.inject (new int[] {10,50,90,60});
        a.dump();
    }
}