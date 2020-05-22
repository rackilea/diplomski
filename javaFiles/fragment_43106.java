static class Consumer implements Runnable {
    public void run() {
        while (true) {
            synchronized (q) {
                if (q.isEmpty()) {
                    try {
                        System.out.println("Q is empty so waiting ");
                        q.wait();
                    }catch(InterruptedException ie) {
                        ie.printStackTrace();
                    }
                } else {
                    System.out.println(q.remove());
                    q.notifyAll();
                }
            }
        }
    }
}