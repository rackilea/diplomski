private final static Queue<String> myQueue = new ConcurrentLinkedQueue<>();

public static void main(String[] args) {

    new Thread(new Adder()).start();
    new Thread(new Consumer()).start();
}

private static class Adder implements Runnable {

    @Override
    public void run() {
        while (true) {
            myQueue.add(String.valueOf(System.currentTimeMillis()));
            try {
                TimeUnit.MILLISECONDS.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

private static class Consumer implements Runnable {

    @Override
    public void run() {

        while (true) {
            for (String value = myQueue.poll(); value != null; value = myQueue.poll()) {
                System.out.println(value);
            }
        }
    }
}