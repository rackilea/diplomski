ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Runnable handler = new Runnable() {
           public void run() { 
                // handle file
           }
    };
    scheduler.scheduleAtFixedRate(handler, 10, 10, SECONDS);