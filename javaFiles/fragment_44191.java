public class IntListUtils {
    public interface IntIntComparator {
        int compare(int a, int b);
    }

    public static void sort(MutableIntList subject, IntIntComparator comparator) {
        quicksort(subject, 0, subject.size() - 1, comparator);
    }

    public static void quicksort(MutableIntList subject, int low, int high, IntIntComparator comparator) {
        if (low >= high) { return; }
        int pivot = partition(subject, low, high, comparator);
        quicksort(subject, low, pivot - 1, comparator);
        quicksort(subject, pivot, high, comparator);
    }

    private static int partition(MutableIntList subject, int low, int high, IntIntComparator comparator) {
        int pivot = subject.get(high);
        int i = low;
        for (int j = low; j <= high - 1; j++) {
            if (comparator.compare(subject.get(j), pivot) < 0) {
                int t = subject.get(i);
                subject.set(i, subject.get(j));
                subject.set(j, t);
                i += 1;
            }
        }
        int t = subject.get(i);
        subject.set(i, subject.get(high));
        subject.set(high, t);
        return i;
    }
}