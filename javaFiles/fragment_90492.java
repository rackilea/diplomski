import java.util.Random;

public class Solution {
    public static void main(String args[]) {
        // give any random number as seed depend on which your random numbers are
        // generated
        // and as long as seed is same the random numbers generated are same
        long seed = 792839098;
        Random random = new Random(seed);
        int Array[] = new int[10];
        for (int i = 0; i < Array.length; i++) {
            Array[i] = random.nextInt();
        }
        System.out.println("your same random numbers are ");
        for (int i = 0; i < Array.length; i++) {
            System.out.println(Array[i]);
        }
    }
}