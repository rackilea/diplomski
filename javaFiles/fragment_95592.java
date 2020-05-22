import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrays {
    public static void main(String[] args) {
        String[] elements = new String[]{"Bread", "Milk", "Cereal", "Coffee"};
        for (int i = 0; i < 15; i++) {
            final String[] array = generateRandomArrayFromElements(elements);
            System.out.println(Arrays.toString(array));
        }
    }

    private static String[] generateRandomArrayFromElements(String[] elements) {
        int size = ThreadLocalRandom.current().nextInt(0, elements.length) + 1;
        String[] array = new String[size];
        ArrayList<Integer> usedIndices = new ArrayList<>(size);
        for (int i = 0; i < array.length; i++) {
            int randomIndex = getUniqueRandomIndex(usedIndices, size);
            usedIndices.add(randomIndex);
            array[i] = elements[randomIndex];
        }
        return array;
    }

    private static int getUniqueRandomIndex(ArrayList<Integer> usedIndices, int max) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, max);
        final boolean contains = usedIndices.contains(randomIndex);
        if (contains)
            randomIndex = getUniqueRandomIndex(usedIndices, max);
        return randomIndex;
    }
}