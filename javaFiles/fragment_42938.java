public class MyRunnable implements Runnable {
    private final Listener listener;

    public MyRunnable(Listener listener) {
        this.listener = listener;
    }

    public void run() {
        while (true) {
            doA();
            listener.callback()
        }
    }
}

public interface Listener {
    void callback();
}

class B implements Listener {
    B() {
        new Thread(new MyRunnable(this)).start();
    }

    @Override
    public void callback() {
        do_B_function();
    }

    public void do_B_function(){}
}