Timer timer = new Timer(true);
    timer.schedule(new TimerTask() {
        public void run() {
            System.out.println("abc");
        }
    }, 100 , 1000);

    try {
        Thread.sleep(10000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }