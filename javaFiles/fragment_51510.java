import java.util.*;

class Example {
    static Integer[] getSortedIndexes(final long[] arr) {
        Integer[] indexes = new Integer[arr.length];
        for (int n = 0; n < indexes.length; ++n) {
            indexes[n] = n;
        }
        Arrays.sort(indexes, (left, right) -> Long.compare(arr[right], arr[left]));
        return indexes;
    }
    public static void main(String[] args) {
        long[] arr = {1983, 321, 63, 832, 455, 1466, 788, 25425, 1839};
        Integer[] indexes = getSortedIndexes(arr);
        System.out.println(Arrays.toString(indexes));
    }
}