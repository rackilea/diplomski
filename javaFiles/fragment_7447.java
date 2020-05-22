public class Concurrent {

    public static Container container = new Container();


    public static void main(String[] args) {
        new Thread(new Filler()).start();
        new Thread(new Killer()).start();
        new Thread(new Reader()).start();
    }

    static class Filler implements Runnable {
        @Override
        public void run() {
            while(true) {
                container.addOne();
            }
        }
    }

    static class Killer implements Runnable {
        @Override
        public void run() {
            while(true) {
                container.removeOne();
            }
        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            while(true) {
                container.readBuffer();
            }
        }
    }
}