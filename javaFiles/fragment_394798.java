import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

import java.util.ArrayList;

public class ListsBenchmark extends SimpleBenchmark {

    private final ArrayList<Integer> list = new ArrayList<Integer>();
    int[] regArray = new int[1];
    long total;

    @Override
    protected void setUp() throws Exception {
        list.add(0);
        total = 0;
    }

    public long timeArrayAndPrimitiveType(int reps) {
        for (int i = 0; i < reps; i++) {
            regArray[0] = i + 10;
            if (regArray[0] % 1000 == 0)
                total += regArray[0];
        }
        return total;
    }

    public long timeListWithAutoboxing(int reps) {
        for (int i = 0; i < reps; i++) {
            list.set(0, i + 10);
            if (list.get(0) % 1000 == 0)
                total += list.get(0);
        }
        return total;
    }

    public long timeNoAutoboxing(int reps) {
        for (int i = 0; i < reps; i++) {
            list.set(0, new Integer(i + 10));
            if (list.get(0).intValue() % 1000 == 0)
                total += list.get(0).intValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Runner.main(ListsBenchmark.class, new String[]{});
    }

}