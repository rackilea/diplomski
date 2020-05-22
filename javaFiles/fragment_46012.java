import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class CountdownLatchTest {
    static volatile boolean signal;
    CountDownLatch latch = new CountDownLatch(1);
    long elapsedTime;
    long[] wakeupTimes = new long[2];

    @Before
    public void setUp() throws Exception {
        signal = false;
    }

    @Test
    public void successfulCountDownDuringFirstAwait() throws Exception {
        countDownAfter(150);
        runCodeUnderTest();
        assertThat((double) elapsedTime, closeTo(150, 10));
        assertThat(wakeupTimeSeparation(), lessThan(10));
    }

    @Test
    public void successfulCountDownDuringSecondAwait() throws Exception {
        countDownAfter(450);
        runCodeUnderTest();
        assertThat((double) elapsedTime, closeTo(450, 10));
        assertThat((double) wakeupTimeSeparation(), closeTo(150, 10));
    }

    @Test
    public void neverCountDown() throws Exception {
        runCodeUnderTest();
        assertThat((double) elapsedTime, closeTo(650, 10));
        assertThat((double) wakeupTimeSeparation(), closeTo(350, 10));
    }

    @Test
    public void countDownAfterSecondTimeout() throws Exception {
        countDownAfter(1000);
        runCodeUnderTest();
        assertThat((double) elapsedTime, closeTo(650, 10));
        assertThat((double) wakeupTimeSeparation(), closeTo(350, 10));
    }

    @Test
    public void successfulCountDownFromSignalField() throws Exception {
        countDownAfterSignal();
        runCodeUnderTest();
        assertThat((double) elapsedTime, closeTo(300, 10));
    }

    private int wakeupTimeSeparation() {
        return (int) (wakeupTimes[1] - wakeupTimes[0]);
    }

    private void runCodeUnderTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        latch.await(300, TimeUnit.MILLISECONDS);
        wakeupTimes[0] = System.currentTimeMillis();
        signal = true;
        latch.await(350, TimeUnit.MILLISECONDS);
        wakeupTimes[1] = System.currentTimeMillis();
        elapsedTime = wakeupTimes[1] - start;
    }

    private void countDownAfter(final long millis) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(millis);
                latch.countDown();
            }
        }).start();
    }

    private void countDownAfterSignal() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean trying = true;
                while (trying) {
                    if (signal) {
                        latch.countDown();
                        trying = false;
                    }
                    sleep(5);
                }
            }
        }).start();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Unexpected interrupt", e);
        }
    }
}