Runnable r = new Runnable() {

    @Override
    public void run() {
        System.out.println("inside runnable");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
           //
        }
    }
}