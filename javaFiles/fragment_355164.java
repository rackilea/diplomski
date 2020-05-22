public class ClassThread implements Runnable {
    private volatile String var;

    public ClassThread(String var) {
        this.var = var;
    }

    @Override
    public void run() {

    }
}