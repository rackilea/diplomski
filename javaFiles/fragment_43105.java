static class Producer implements Runnable {
    public void run() {
        while (true) {
            synchronized (q) {
                if (q.size() < 10) {
                    String st = System.currentTimeMillis() + "";
                    q.add(st);
                    q.notifyAll();
                } else {
                    try {
                        System.out.println("Q is full so waiting");
                        q.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}