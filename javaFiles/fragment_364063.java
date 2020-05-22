new Thread(new Runnable() { //create new thread
    @Override
    public void run() {
        try {
            Thread.sleep(5000); //wait here
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        System.exit(0); //kill Java process
    }
}).start(); //start new thread
//EDT thread should continue executing