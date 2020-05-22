public class A {

    Thread thread;

    public A () {
        thread = new Thread() {
            @Override public void run() {
                while(!isInterrupted()) {
                    //Do work
                }
            }
        };
        thread.start();
    }

    void stop () {
        thread.interrupt();
        thread.join(); // if you want
    }

}