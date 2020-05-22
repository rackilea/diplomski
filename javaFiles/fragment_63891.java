new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000); // 3 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                 //your Function
                }
            });
        }
    }).start();