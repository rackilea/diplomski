new Thread(new Runnable() {

    @Override
    public void run() {
        // Your infinite loop here
        while(true) {
            System.out.println(0);
        }
    }
}).start();