public static <T extends Comparable<T>> void sort(T[] array) {
    Map<T, Integer> counts = new TreeMap<>();

    for(T t : array) {
        counts.merge(t, 1, Integer::sum);
    }

    int i=0;
    for(Map.Entry<T, Integer> entry : counts.entrySet()) {
        for(int j=0; j<entry.getValue(); j++)
            array[i++] = entry.getKey();
    }
}

public static void main(String[] args) {
    Integer[] data = { 5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4 };
    System.out.println("Before: " + Arrays.toString(data));

    sort(data);
    System.out.println("After:  " + Arrays.toString(data));

    Character[] chars = { 'A', 'Z', 'B', 'D', 'F' };
    System.out.println("Before: " + Arrays.toString(chars));

    sort(chars);
    System.out.println("After:  " + Arrays.toString(chars));
}