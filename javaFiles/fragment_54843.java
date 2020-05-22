interface MyTaskCallback {
    void myTaskCallback();
}
class MyTask implements Runnable {  
    MyTaskCallback callback;
    Thread me;
    public MyTask(MyTaskCallback callback) {
        this.callback = callback;
        this.me = new Thread();
    }

    public void start() {
        this.me = new Thread(this);
        this.me.start();
    }

    public void stop() {
        try {
            this.me.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        // Calls here will not block the other threads
        sendEmailRequest();
        callback.myTaskCallback();
    }
}

class Main implements MyTaskCallback {
    public void foo() {
        MyTask m = new MyTask(this);
        m.start();
    }

    public void myTaskCallback() {
        // called when MyTask completes
    }
}