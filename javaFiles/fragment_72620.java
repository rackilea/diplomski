Thread thread =
  new Thread(new Runnable() {
    @Override
    public void run() {
        try {
          someMethod();
          System.out.println("thread finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread is going to die");
    }
  });

thread.start( );

final long reasonableTimeout = ...;

thread.join( reasonableTimeout );

// THIS WILL SHAKE IT UP
thread.interrupt( );

thread.join( );

// At this point, it is guaranteed that the thread has finished