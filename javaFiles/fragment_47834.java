import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

public class TM2_AllocationSpeedTest extends TestCase {

    public void testAllocation() throws Throwable {

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
            String a = "dummy";
            for (int j = 0; j < 1000; j++) {
                a += "allocation driven";
            }
            long endTime = System.currentTimeMillis();
            System.out.println(this + ": " + (endTime - startTime) + "ms " + a.length());
        }

    }

}