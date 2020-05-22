public class CounterMultiplexer {

    private int counter =0;
    private int multiPlexer =5;
    private Object mutex = new Object();

    public void claculate(){

        synchronized(mutex){
            counter ++;
            multiPlexer = multiPlexer*counter;
        }
     }

   public int getCounter(){
      synchronized(mutex){
        return counter;
     }
   }

   public int getMux(){
      synchronized(mutex){
        return multiPlexer;
      }
   }
}