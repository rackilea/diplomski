Runnable r = new Runnable() {
    @Override
    public void run() {
        MainWork a = new MainWork(); 
        a.doWork();
    }
};

new Thread(r).start();