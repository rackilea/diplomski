new Thread(new Runnable() {
        @Override
        public void run() {
            long delay = 1; //seconds
            for(your condition here) {
                //send data here

                Thread.sleep(1 * 1000);
            }
        }
    }).start();