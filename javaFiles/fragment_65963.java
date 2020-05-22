final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int minute = 1;
            @Override
            public void run() {
                {
                    //do something...
                    long delay = minute * 60000;                        
                    handler.postDelayed(this,delay);
                }
            }
        }, 0);