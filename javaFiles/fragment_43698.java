final Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        int n = 0;
        @Override
        public void run() {
            System.out.println(n);
            if (++n == 5) {
                timer.cancel();
            }
        }
    },1000,1000);