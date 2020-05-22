List<Object> mutexList;
//initialize the list with plain Objects. You just need them to be separate instances.
....
//When creating Element threads add one object from the list to each Element.
....
//in Element code
public class Element extends Thread {
   //This is one element from the list 
   private Object mutex;


    public void run() {
       // do something to get an object from another class (a queue)
       //....
       synchronized(mutex){ 
          mutex.wait();
       }
    }
}
// in timerTask code
 public class PeriodicTime extends TimerTask {

    List<Object> mutexList;

    @Override
    public void run() {

        if(counter > 0) {
            //do some stuff to wake up threads
           for(Object mutex:mutexList){
                mutex.notify();
           }
        }
        counter++;
    }
}