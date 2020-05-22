import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int total = 0;
        for (int seed = 0; seed < 4000; seed++) {
            Random rng = new Random(seed);
            total += rng.nextInt(2);
        }
        System.out.println(total);
    }
}