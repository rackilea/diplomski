public class Testit {

    public static void main(String[] args) {
        busted t = new busted();
        t.start();
        try {
        Thread.sleep(1000L);
        } catch (Exception e) {}
        t.startUpdating();

}

    public static class busted extends Thread {

        private boolean start = false;

        public void startUpdating() {
            start = true;
        }

        @Override
        public void run() {
            updateTimeElapsedIndefinitely();
        }

        public void updateTimeElapsedIndefinitely() {
            while (true) {
                if (start) {
                    System.out.println("Hello");
                }
            }
        }
    }
}