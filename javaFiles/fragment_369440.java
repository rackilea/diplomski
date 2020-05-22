class Test {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> list = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread() {

                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        Counter.getInstance().n.incrementAndGet();
                    }
                }
            });
        }
        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }

        System.out.println(Counter.getInstance().n);
    }
}

class Counter {
    public AtomicInteger n = new AtomicInteger(0);

    public static Counter getInstance() {
        return Holder.instance;
    }
    private static class Holder {
        private static final Counter instance = new Counter();
    }
}