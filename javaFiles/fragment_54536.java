import java.util.function.IntConsumer;
import java.util.stream.IntStream;

class Testing {
    private int N;
    public Testing (int n) {
        N = n;
    }

    private static int f (int x) {
        return 2*x;
    }

    public void print_f(IntConsumer action) {
        IntStream.range(0, this.N).forEach(action);
    }

    public static void main (String[] args) {
        int n = 10;
        if (args.length == 1)
            n = Integer.parseInt(args[0]);
        Testing t = new Testing (n);
        t.print_f(i->System.out.println(f(i)));
    }
}