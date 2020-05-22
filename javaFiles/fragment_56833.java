public class Generic {
    public static <T extends Comparable<T>> T Max(T[][]stuff) {
        T max = stuff[0][0];
        for (T[] row : stuff) {
            for (T elt : row) {
                if (elt.compareTo(max) > 0) {
                    max = elt;
                }
            }
        }
        return max;
    }
}