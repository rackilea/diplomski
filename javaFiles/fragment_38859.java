Thread thread = new Thread(new Runnable() {
    public void run() {
        SomeClass.main(new String[]{});
    }
});
thread.start();