public void run() {                   <<< (1) this thread starting 
            if (Thread.interrupted()) {       <<< (2.1) Am I interrupted? (Not yet, so no)
                 System.out.println("Thread has been interrupted");
                 System.out.println(Thread.currentThread().isInterrupted());
                                              <<< (2.2) Finished executing. This thread is done.
            }
        }