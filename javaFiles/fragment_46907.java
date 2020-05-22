import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DeepRecursion {

    private long returnStartTime;

    public int recurse(int i) {
        int r = (int)Math.sqrt((double)i); // Some non-trivial computation
        if(i == 0) {
            returnStartTime = System.currentTimeMillis();
            return r;
        }
        return r + recurse(i-1);
    }

    public void testRecursion(int i, PrintStream p) {
        long startTime = System.currentTimeMillis();
        int result = recurse(i);
        long endTime = System.currentTimeMillis();

        p.println(
                "Recursion depth: " + i + " Result: " + result + "\n" +
                "Time for recursion" + (returnStartTime - startTime) + "\n" +
                "Time for return " + (endTime - returnStartTime) + "\n"
                );
    }

    public void testIteration(int i, PrintStream p) {
        long startTime = System.currentTimeMillis();
        int result = 0;
        for(int k = 0; k <= i; k++) {
            int r = (int)Math.sqrt((double)k); // Some non-trivial computation
            result += r;
        }
        long endTime = System.currentTimeMillis();
        p.println("Iteration length: " + i + " Result: " + result + "\nTime: " + (endTime - startTime) );
    }

    public static void main(String[] args) {
        DeepRecursion r = new DeepRecursion();
        PrintStream nullStream = new PrintStream(new ByteArrayOutputStream());

        for(int k = 0; k < 10; k++) {
            // Test stack depths from 1024 to 33554432
            for(int i = 10; i < 26; i++) {
                r.testIteration(1 << i, k == 9 ? System.out : nullStream);
                r.testRecursion(1 << i, k == 9 ? System.out : nullStream);
            }
        }
    }
}