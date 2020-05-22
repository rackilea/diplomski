//inside of your listner
public void someRecordEventHappened(RecordEvent event){
    new Thread(new Runnable
    {
         private final RecordEvent eventDate = event;
         @Override
         public void run()
         {
             //do stuff asynchronously 
         }
    }).start();
}