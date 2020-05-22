public class Utils {
    public static <T extends Comparable<? super T>> Collection<T> toSortedList(Collection<T> col) {
        List<T> sorted = new ArrayList<T>(col);
        Collections.sort(sorted);
        return sorted;
    }
}