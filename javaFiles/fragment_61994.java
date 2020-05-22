Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try { Thread.sleep(1000); }
                    catch (InterruptedException e) { e.printStackTrace(); }
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            copyMethod();
                        }
                    });
                }
            }
        };