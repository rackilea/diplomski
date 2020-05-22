Handler handler = new Handler();
    Runnable r=new Runnable() {
              @Override
              public void run() {
                finish();
              }         
            };
        handler.postDelayed(r, 2000);