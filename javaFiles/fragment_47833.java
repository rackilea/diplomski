import java.util.ArrayList;
import java.util.List;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
import junit.framework.TestCase;

public class TM1_CalculationSpeedTest extends TestCase {

    public void testCalculation() throws Throwable {

        List threads = new ArrayList();
        for (int i = 0; i < 100; i++) {
            threads.add(new Requester());
        }
        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner((TestRunnable[]) threads.toArray(new TestRunnable[threads.size()]));
        mttr.runTestRunnables(2 * 60 * 1000);

    }

    public class Requester extends TestRunnable {

        public void runTest() throws Exception {
            long startTime = System.currentTimeMillis();
            long a = 0;
            for (int j = 0; j < 10000000; j++) {
                a += j * j;
            }
            long endTime = System.currentTimeMillis();
            System.out.println(this + ": " + (endTime - startTime) + "ms " + a);
        }

    }

}