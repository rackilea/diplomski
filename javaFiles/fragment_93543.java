public class MyApplication extends Application {
    private int instanceCount;

    public void incrementInstanceCount() {
        instanceCount++;
    }

    public int decrementInstanceCount() {
        return --instanceCount;
    }
}