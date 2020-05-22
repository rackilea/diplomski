Thread t = new Thread() {
        @Override
        public void run() {
            try {
                    //check if connected!
                while (!isConnected(WifiExplorerActivity.this)) {
                    //Wait to connect
                    Thread.sleep(1000);                     
                }

                Intent i = new Intent(WifiExplorerActivity.this, MainActivity.class);
                startActivity(i);

            } catch (Exception e) {
            }
        }
    };
    t.start();