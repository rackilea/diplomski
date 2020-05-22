public class Counter {
    // The instance member we'll use, note that we initialize it to `null`
    // because you have a zero-args constructor, so we want to be sure we
    // know whether we have one or not
    private Counter otherCounter = null;

    public Counter() {}

    public Counter(Counter oldCounter) {
        // Remember it here
        this.otherCounter = oldCounter;
    }

    public void someMethod() {
        // Use it here
        if (this.otherCounter != null) {
            this.otherCOunter.someOtherMethod();
        }
    }
}