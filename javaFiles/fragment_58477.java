btnEnter.setOnClickListener(new Button.OnClickListener(){

           @Override
              public void onClick(View arg1) {
               arg1.startAnimation(animAlpha2); 

Thread thread = new Thread() {
            @Override
            public void run() {
                // Block this thread for 2 seconds.
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }

                // After sleep finished blocking, create a Runnable to run on
                // the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      startActivity(new Intent(getApplication(),SecondActivity.class)); 
                    }

                });
            }
        };

        // Don't forget to start the thread.
        thread.start();



              }}); 
 }