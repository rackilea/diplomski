import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomArrays {
    public static void main(String[] args) {
        String[] elements = new String[]{"Bread", "Milk", "Cereal", "Coffee"};
        for (int i = 0; i < 15; i++) {
            final String[] array = generateRandomArrayFromElements(elements);
            System.out.println(Arrays.toString(array));
        }
    }

    private static String[] generateRandomArrayFromElements(String[] elements) {
        final List<String> list = Arrays.asList(elements);
        Collections.shuffle(list);
        return list.toArray(new String[list.size()]);
    }
}