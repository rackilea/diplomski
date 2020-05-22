public class Meeting{
     CylicBarrier barrier = new CylicBarrier(numberOfEmployees);

     public void waitForAllOthersToArrive(){
         barrier.await(); //when await() is called numberOfEmployees then all waiting threads will awake
     }
 }