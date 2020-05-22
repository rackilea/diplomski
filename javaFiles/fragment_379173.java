ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
int count=0;
scheduler.scheduleAtFixedRate
  (new Runnable() {
     public void run() {
        if(count==0)
          findViewById(R.id.textView1).setVisibility(00000004);
      else if(count==1)
          findViewById(R.id.textView2).setVisibility(00000004);
      else if(count==2)
          findViewById(R.id.textView3).setVisibility(00000004);
      else if(count==3)
          findViewById(R.id.textView4).setVisibility(00000004);   
      count++;
     }
  }, 0, 8, TimeUnit.SECONDS);