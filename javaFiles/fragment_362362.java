public class ShuffledIntStream {

    public static IntStream to(int max) {
        Random r = new Random();
        int[] values = new int[max];
        for (int i = 0; i < max; i++) {
            values[i] = i;
        }
        for (int i = max; i > 1; i--) {
            swap(values, i - 1, r.nextInt(max));
        }
        return IntStream.of(values);
    }

    private static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}