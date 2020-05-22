import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class ShufflePixels {
    private static List<Integer> shuffleIntegers(int n, long seed) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Collections.shuffle(list, new Random(seed));
        return list;
    }

    public static void main(String[] args) {
        int height = 2;
        int width = 3;
        long seed = 34758L;

        List<Integer> pixelOrder = shuffleIntegers(height * width, seed);

        for (int pixel : pixelOrder) {
            int x = pixel / width;
            int y = pixel % width;
            System.out.println(x + " " + y);
        }
    }
}