import sun.management.ManagementFactoryHelper;
import sun.management.counter.Counter;
import java.util.NoSuchElementException;

public class Test {

    public static void main(String[] args) {
        System.out.println(getContendedLockAttempts());
    }

    private static long getContendedLockAttempts() {
        for (Counter counter : ManagementFactoryHelper.getHotspotRuntimeMBean().getInternalRuntimeCounters()) {
            if ("sun.rt._sync_ContendedLockAttempts".equals(counter.getName())) {
                return (long) counter.getValue();
            }
        }
        throw new NoSuchElementException();
    }
}