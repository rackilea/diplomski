SumThread mt2 = new SumThread("Thread #2", a);
    try{
      Thread.sleep(1000);//make to main thread to sleep before mt1.thrd.join() could be called.
     }catch(Exception ex){ex.printStackTrace();}
    try {
        mt1.thrd.join();
      ....