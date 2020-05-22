public class IncreaseTest {
    private int value = 0;

    public synchronized int increment() {
        return value++;
    }
}