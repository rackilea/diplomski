public class Main {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyRunnable("http://someaddress"));
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable("http://otheraddress"));
        thread2.start();

    }

    public static class MyRunnable implements Runnable {

        String address;

        public MyRunnable(String address) {
            this.address = address;
        }

        @Override
        public void run() {
            // My code here that can access address
        }
    }
}