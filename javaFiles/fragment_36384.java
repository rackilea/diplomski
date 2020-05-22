boolean needsToWaitForUserInput = false;
final ReentrantLock lock = new ReentrantLock();
final Condition waitingCondition = lock.newCondition();

private final Runnable networkRunnable=new Runnable(){ 
  public void run(){
      //get network information
      lock.lock();
      needsToWaitForUserInput  = true;
      try{      
         while(needsToWaitForUserInput ){
            waitingCondition.await();
         }
      }finally{ 
          lock.unlock();
      }
   }
}
    public void signalJobToContinue(){
      lock.lock();
      try{      
            needsToWaitForUserInput =false;
            waitingCondition.signal();
      }finally{ 
         lock.unlock(); 
      }

}