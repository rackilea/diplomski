java.util.Timer t = new java.util.Timer();
t.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("This will run every 5 seconds");

            }
        }, 5000, 5000);