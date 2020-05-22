Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<Runnable>();
@Override
public void run(){
   while (looprunning) {
       //do stuff here
     //update another system here or something else.
     Runnable r = taskQueue.poll();
     if(r!=null)r.run();
   }
}