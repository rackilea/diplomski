public class DoSomething {
    private final ReadOnlyDoubleWrapper progress = new ReadOnlyDoubleWrapper(this, "progress");
    public double getProgress() {
        return progress.get();
    }
    public ReadOnlyDoubleProperty progressProperty() {
        return progress.getReadOnlyProperty();
    }
    public void veryLongAndTimeConsumingMethod(int i) {
        // ..
        progress.set(...);
    }
}