import com.google.caliper.SimpleBenchmark;

public class ToInt extends SimpleBenchmark {

    private byte[] n;
    private int total;

    @Override
    protected void setUp() throws Exception {
        n = new byte[4];
    }

    public int timeStaticClass(int reps) {
        for (int i = 0; i < reps; i++) {
            total += StaticClass.toInt(n);
        }
        return total;
    }

    public int timeFromClass(int reps) {
        for (int i = 0; i < reps; i++) {
            total += toInt(n);
        }
        return total;
    }

    public int timeInline(int reps) {
        for (int i = 0; i < reps; i++) {
            int actual = 0;
            int len = n.length;
            for (int i1 = 0; i1 < len; i1++) {
                actual += n[len - 1 - i1] << 8 * i1;
            }
            total += actual;
        }
        return total;
    }

    public static int toInt(byte[] num) {
        int actual = 0;
        int len = num.length;
        for (int i = 0; i < len; i++) {
            actual += num[len - 1 - i] << 8 * i;
        }
        return actual;
    }
}

class StaticClass {
    public static int toInt(byte[] num) {
        int actual = 0;

        int len = num.length;

        for (int i = 0; i < len; i++) {
            actual += num[len - 1 - i] << 8 * i;
        }

        return actual;
    }

}