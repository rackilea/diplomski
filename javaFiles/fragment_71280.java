final Object lock = new Object(); //Lock object for synchronization.
    final Thread mainThread = Thread.currentThread(); //Reference to the current thread.

    Runtime.getRuntime().addShutdownHook(new Thread()
    {
        public void run()
        {
            try{
                synchronized(lock){
                  running = false;
                  lock.notifyAll();
                }

                mainThread.join(4000);
            }catch(InterruptedException){
               //Interrupted.
            }
        }
    });

    synchronized(lock){
        while (running && !Thread.currentThread().isInterrupted())
        {
            myApp.CreateMyThread();

            System.out.println("Keeping busy.");
            lock.wait(2000); 
        }
     }