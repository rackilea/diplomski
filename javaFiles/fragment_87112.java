Timer timer=new Timer();
//Handler handler=new Handler();
timer.scheduleAtFixedRate(new TimerTask()
{
    public void run()
    {       
       runOnUiThread(new Runnable() {

          @Override
          public void run() {
             loadLayout();
          }
      });
    }

}, 1000, 10000000);