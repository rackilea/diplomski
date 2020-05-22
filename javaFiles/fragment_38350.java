// create an anonymous implementation of Runnable
Runnable r = new Runnable() {
     @Override
     public void run() {
       // the run implementation
     }
   };

// create a Thread
Thread t = new Thread(r);

// start the Thread -> will call the run method from the Runnable
t.start();