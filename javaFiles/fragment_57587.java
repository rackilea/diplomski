public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        YourData yourData = new YourData();
        new Thread(new BackThread(yourData)).start();

        Thread.sleep(5000);
        //set to 5 in background thread
        System.out.println(yourData.i);
        yourData.i += 1;
        //set to 6 in this thread
        System.out.println(yourData.i);
    }

}

public class YourData {
    public int i = 0;
}

public class BackThread implements Runnable {

    private YourData data;

    public BackThread(YourData data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.i += 5;
    }

}