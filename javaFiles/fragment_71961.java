public class FibMain {
    public static void main(String... args) {
        {
            long start = System.nanoTime();
            System.out.println(iteration_fib(Integer.parseInt(args[0])));
            long time = System.nanoTime() - start;
            System.out.printf("Iteration took %,d us%n", time /  1000);
        }
        {
            long start = System.nanoTime();
            System.out.println(recursive_fib(Integer.parseInt(args[0])));
            long time = System.nanoTime() - start;
            System.out.printf("Recursion took %,d us%n", time /  1000);
        }
    }

    public static long iteration_fib(int n) {
        long t1 = 1;
        long t2 = 1;
        while (n-- > 2) {
            long t = t2;
            t2 += t1;
            t1 = t;
        }
        return t2;
    }

    public static long recursive_fib(int n) {
        if (n <= 2) return 1;
        return recursive_fib(n - 1) + recursive_fib(n - 2);
    }
}