final public class PoorMansUuid
{
    private static final AtomicInteger counter = new AtomicInteger(100000);

    public static int generateUuid() {
        return counter.getAndIncrement();
    }
}