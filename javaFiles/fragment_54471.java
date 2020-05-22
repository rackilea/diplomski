boolean mStatus = true;

   @Override
    public void onCreate() {
        1Thread = new Thread() {
            public void run() {
                while (mStatus) {
                        try {
                            Thread.sleep(180000); // 3 minutes
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            continue;

                        }
                        Log.i("TEST", "Thread is still here!");

            }
        };


    }



@Override
    public void onDestroy() {
         mStatus = false;
         1Thread.interrupt();
    }