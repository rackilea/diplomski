public class Signal {

     private boolean signal;

     public void waitForSignal() {
          while (true)
               sychronized (this) {
                    if (signal) {
                        signal = false;
                        break;   
                    }
               }
           }
     }

     public synchronized void notifyWithSignal() {
          signal = true;
     }
}