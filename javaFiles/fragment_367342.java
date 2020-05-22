if (array1[0]>array1[1])
    {
    AnimationClass a = new AnimationClass();
    a.jButtonYUp(110, 30, 100,1, jButton6);
    a.jButtonXLeft(250, 50, 100, 1, jButton6);
    a.jButtonXRight(50, 250, 100, 1, jButton5);

    Timer timer1 = new Timer();
    MyTimerTask timer1_task = new MyTimerTask();
    timer1.schedule (timer1_task, 2000, 0);

    }  



 class MyTimerTask extends TimerTask
 {
  public void run()
  {
     a.jButtonYDown(30, 110, 100, 1, jButton2);
  }
 }