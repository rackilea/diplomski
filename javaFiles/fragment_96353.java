TimerTask task = new TimerTask()
      {
        public void run()
         {
          elapsed++;
              runOnUiThread(new Runnable() //run on ui thread
                 {
                  public void run() 
                  { 


                     loadingRaven.setAlpha((float)(Math.sin(elapsed)+1)/2)
                 }
                 });

     }
  };