final Handler handler = new Handler();
Timer timer = new Timer();
TimerTask doTask = new TimerTask() {       
    @Override
    public void run() {
        handler.post(new Runnable() {
            @SuppressWarnings("unchecked")
            public void run() { 
               try {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                   }
             catch (Exception e) {
                    // TODO Auto-generated catch block
                }
            }
        });
    }
};
timer.schedule(doTask, 0, "Your time 10 minute");