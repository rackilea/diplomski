public class MyTask extends TimerTask {
       private String msg;
       private String to;
       public Mytask(String msg, String to) {
          this.msg = msg;
          this.to = to;
       }

       public void run() {
           // process message
       }
   }

   Timer timer = new Timer();

   while (...) {
       // read message
       timer.schedule(new MyTask(msg, to), waitTime);
   }