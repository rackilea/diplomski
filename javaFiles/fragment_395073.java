final Timer myTimer = new Timer();
    myTimer.schedule(new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ProgressBar temppb;
                    for (int i = 0; i < (totalnumberofprogressbars); i++) {
                            temppb = (ProgressBar) findViewById(i + 1);
                            temppb.setProgress(0);
                    }
                }
            });

            myTimer.cancel();
        }
    }, 50,50);