static public class Worker implements Runnable {

    private String data = null;

    public void setData(String data) {
        this.data = data;
        synchronized(this) {
            notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized(this) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("data = " + data);
        }
    }
}