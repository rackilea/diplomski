import java.util.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
        test();
        }
    }

    private static void test() {
        long start = System.currentTimeMillis();
        long limit = 10000000; //10^9
        long value = 0;
        for(long i = 0; i < limit; ++i){}
        long t1 = System.currentTimeMillis() - start;
        start = System.currentTimeMillis();
        for(long j = 0; j < limit; ++j) {
            value = value + j;
        }
        long t2 = System.currentTimeMillis() - start;
        start = System.currentTimeMillis();
        for(long k = 0; k < limit; ++k) {
            value = value + (new Long(k));
        }
        long t3 = System.currentTimeMillis() - start;
        System.out.print(t1 + " " + t2 + " " + t3 + " " + value + "\n");
    }
}