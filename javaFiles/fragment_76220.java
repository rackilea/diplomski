Runnable r = new Runnable() {
    @Override public void run() {
        try {
            while (!Thread.currentThread.isInterrupted()) {}
        } finally {
            System.out.println("FINALLY");
        }
    }
};