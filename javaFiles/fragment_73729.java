public class Foo {
    final Bar bar = new Bar();

    private int instanceCounter = 0;
    private int barCounter = 0;

    public synchronized void incrementBarCounterIfAllowed() {
        synchronized (bar) {
            if (instanceCounter < 10) barCounter++;
        }
    }

    public synchronized void incrementClassCounter() {
        instanceCounter++;
    }

    public void incrementBarCounter() {
        synchronized (bar) {
            barCounter++;
        }
    }

}