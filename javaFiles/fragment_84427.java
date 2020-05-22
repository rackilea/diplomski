public class MyRunnableThread implements Runnable {

    boolean run = true;

    String fname;

    public MyRunnableThread(String fname) {
        this.fname = fname;
    }

    public void setRun(boolean toSet) {
        run = false;
    }

    public void run() {
        while (run) {
            doStuff();
        }
    }

    private void doStuff() {
//       File.read(fname);
    }
}