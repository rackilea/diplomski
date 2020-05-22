Thread threadB = new Thread(new Runnable() {
    public void run() {
        try {
           myRunnable.run();
        } finally {
           doStuff();
        }
    }
});