class WorkerThread implements Runnable {
    int x, y;
    public WorkerThread(int y) {
        this.y = y;
    }

    public void run() {
        System.out.println(x+y);
    }
}