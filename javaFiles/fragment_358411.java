public class Midlet extends MIDlet {
 ThreadClass th = null;
 Thread myThread = null;

 public void startApp() {
  if (th==null) {
   th = new ThreadClass();
   myThread = new Thread(th);
  }
  myThread.start();
 }

 public void pauseApp() {
 }

 public void destroyApp(boolean unconditional) {
 }
}

class ThreadClass implements Runnable{ 

 ThreadClass() {
 }

 public void run() {
  System.out.println("We are in Thread");
 }          
}