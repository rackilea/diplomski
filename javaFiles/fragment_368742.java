import java.util.*;

public class CompareSortedLists {
    public static void main(String[] args) {
        List<Integer> sourceDbResults = Arrays.asList(1, 2, 3, 4, 5, 8);
        List<Integer> hiveResults = Arrays.asList(2, 3, 6, 7);
        List<Integer> inSourceDb_notInHive = new ArrayList<>();
        List<Integer> inHive_notInSourceDb = new ArrayList<>();

        compareSortedLists(
                sourceDbResults, hiveResults,
                inSourceDb_notInHive, inHive_notInSourceDb);

        assert inSourceDb_notInHive.equals(Arrays.asList(1, 4, 5, 8));
        assert inHive_notInSourceDb.equals(Arrays.asList(6, 7));
    }

    /**
     * Compares two sorted lists (or other iterable collections in ascending order).
     * Adds to onlyInList1 any and all elements in list1 that are not in list2; and
     * conversely to onlyInList2. The caller must ensure the two input lists are
     * already sorted and should initialize onlyInList1 and onlyInList2 to empty,
     * writable collections.
     */
    public static <T extends Comparable<? super T>> void compareSortedLists(
            Iterable<T> list1, Iterable<T> list2,
            Collection<T> onlyInList1, Collection<T> onlyInList2) {
        Iterator<T> it1 = list1.iterator();
        Iterator<T> it2 = list2.iterator();
        T e1 = it1.hasNext() ? it1.next() : null;
        T e2 = it2.hasNext() ? it2.next() : null;
        while (e1 != null || e2 != null) {
            if (e2 == null) {  // No more elements in list2, some remaining in list1
                onlyInList1.add(e1);
                e1 = it1.hasNext() ? it1.next() : null;
            }
            else if (e1 == null) {  // No more elements in list1, some remaining in list2
                onlyInList2.add(e2);
                e2 = it2.hasNext() ? it2.next() : null;
            }
            else {
                int comp = e1.compareTo(e2);
                if (comp < 0) {
                    onlyInList1.add(e1);
                    e1 = it1.hasNext() ? it1.next() : null;
                }
                else if (comp > 0) {
                    onlyInList2.add(e2);
                    e2 = it2.hasNext() ? it2.next() : null;
                }
                else /* comp == 0 */ {
                    e1 = it1.hasNext() ? it1.next() : null;
                    e2 = it2.hasNext() ? it2.next() : null;
                }
            }
        }
    }
}