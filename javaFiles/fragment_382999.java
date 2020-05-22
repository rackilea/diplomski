public class ThreadTL extends Thread {
    public ThreadTL(Runnable r) {
        super(r);
        setName(getName()+" DF "+executor.getClass().getSimpleName());
    }

    @Override
    public void run() {
        super.run();
    }
}