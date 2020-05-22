Timer timer = new Timer();
         timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       UpdateTimes();
                    }
                });
            }

         },0, 1000);