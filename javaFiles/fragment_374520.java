import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class G1GCTest implements Runnable {
    private int iterations = 0;
    private final Random rnd = new Random();
    private final List<Object> young = new ArrayList<Object>(1000);
    private final List<WeakReference<Object>> old =
            new ArrayList<WeakReference<Object>>(100000);

    private void clearOld() {
        int clearedCnt = 0;
        for (final Iterator<WeakReference<Object>> iter = old.iterator(); iter
                .hasNext();)
        {
            final WeakReference<Object> ref = iter.next();
            if (null == ref.get()) {
                iter.remove();
                clearedCnt++;
            }
        }
        if (0 < clearedCnt) {
            System.out.println("Cleared " + clearedCnt
                    + " weak references to old objects.");
        }
    }

    public void run() {
        if (0 == ++iterations % 10000) {
            System.out.println("iterations=" + iterations + ", young.size()="
                    + young.size() + ", old.size()=" + old.size());
            clearOld();
            try {
                Thread.sleep(100);
            } catch (final Throwable e) {
                // Do nothing!
            }
        }
        if (rnd.nextBoolean()) {
            young.add(new byte[1000]);
        }
        if (rnd.nextBoolean() && !young.isEmpty()) {
            final int nextInt = Math.abs(rnd.nextInt());
            final int idx = nextInt % young.size();
            final Object obj = young.remove(idx);
            old.add(new WeakReference<Object>(obj));
        }
    }

    public static void main(final String[] args) {
        final G1GCTest t = new G1GCTest();
        while (1000000 > t.iterations) {
            t.run();
        }
    }
}