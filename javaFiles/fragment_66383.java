boolean isFirstAnim=true;
Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                          if(isFirstAnim){
                              // play your first animation at every
                          }else{
                              // play your second animation at every
                          }                 
            }
        }, 0, 3000);