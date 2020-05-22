class ThreadTask implements Runnable {
    private int counter = 0;
    private int id;

    public ThreadTask(int id) { this.id = id; }

    public void run() {
        while(counter < 500) {
            counter++;
            System.out.println("T" + id + " " + counter);
        }
    }
}

...

new Thread(new ThreadTask(0)).start();
new Thread(new ThreadTask(1)).start();