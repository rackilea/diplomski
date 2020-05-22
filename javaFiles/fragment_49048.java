public class Boss {
    private final DoThingInALoop toBeMocked;
    private final Executor executor;

    public Boss(final Executor executor, final DoThingInALoop toBeMocked) {
        this.executor = executor;
        this.toBeMocked = toBeMocked;
    }

    public void start() {
        executor.execute(toBeMocked);
    }
}