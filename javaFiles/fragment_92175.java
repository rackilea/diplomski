import java.util.Random;
public class RandomTest {
    public static void main(String[] s) {
        Random rnd1 = new Random(42);
        Random rnd2 = new Random(42);

        System.out.println(rnd1.nextInt(100)+" - "+rnd2.nextInt(100));
        System.out.println(rnd1.nextInt()+" - "+rnd2.nextInt());
        System.out.println(rnd1.nextDouble()+" - "+rnd2.nextDouble());
        System.out.println(rnd1.nextLong()+" - "+rnd2.nextLong());
    }
}