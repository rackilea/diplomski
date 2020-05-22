Timer timer = new Timer();
timer.schedule(new TimerTask() {
    public void run() {
        if (getConnection()) {
            System.out.println("Got connection, do some work.....");
            System.exit(0);  // And/or timer.cancel()
        } else {
            System.out.println("No connection, re-trying in 5 seconds");
        }
    }
}, new Date(), 5000);