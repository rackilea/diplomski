package bench;

import org.openjdk.jmh.annotations.*;
import java.lang.invoke.*;
import java.util.concurrent.*;

@State(Scope.Benchmark)
public class Toggle {
    static boolean toggleField = false;

    static final MutableCallSite toggleCallSite =
            new MutableCallSite(MethodHandles.constant(boolean.class, false));

    static final MethodHandle toggleMH = toggleCallSite.dynamicInvoker();

    public void switchToggle() {
        toggleField = true;
        toggleCallSite.setTarget(MethodHandles.constant(boolean.class, true));
        MutableCallSite.syncAll(new MutableCallSite[]{toggleCallSite});
        System.out.print("*** Toggle switched *** ");
    }

    @Setup
    public void init() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(this::switchToggle, 10100, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }

    @Benchmark
    public int alwaysFalse() {
        return 0;
    }

    @Benchmark
    public int alwaysTrue() {
        return ThreadLocalRandom.current().nextInt();
    }

    @Benchmark
    public int field() {
        if (toggleField) {
            return ThreadLocalRandom.current().nextInt();
        } else {
            return 0;
        }
    }

    @Benchmark
    public int mutableCallSite() throws Throwable {
        if ((boolean) toggleMH.invokeExact()) {
            return ThreadLocalRandom.current().nextInt();
        } else {
            return 0;
        }
    }
}