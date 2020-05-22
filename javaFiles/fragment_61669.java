public Employee extends Thread{

     //define this at some point whether in constructor or a 
     //means of notifying the thread to attend the meeting
      private Meeting meeting;

      public void run(){
          //do some stuff until this employee is ready to go  to a meeting

         meeting.waitForAllOthersToArrive();
      }

    }

   public class Meeting{  
     CountDownLatch latch =  new CountDownLatch(numberOfEmployees);

     public void waitForAllOthersToArrive(){
        latch.countDown();
        latch.await();
     } 
   }