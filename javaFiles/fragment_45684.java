public abstract class AbstractCallable implements Callable<Boolean> {
    private CallableData data;

    protected AbstractCallable(CallableData data) {
        this.data = data;
    }

    protected CallableData getData() {
        return data;
    }
}