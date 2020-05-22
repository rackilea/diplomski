import java.util.concurrent.atomic.AtomicInteger;

public class Accum {
    private static Accum a = new Accum();
    private AtomicInteger counter = new AtomicInteger(0);
    private Accum() {}
    public static Accum getAccum() {
        return a;
    }

    public void updateCounter(int add) {
        counter.addAndGet(add);
    }

    public int getCount() {
        return counter.intValue();
    }
}