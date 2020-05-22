Runnable r = new Runnable() {
    public void run() {
        A.main(argsArray);
    }
};

Thread t = new Thread(r);
t.start();