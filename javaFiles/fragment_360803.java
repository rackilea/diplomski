public void run()
{
  int permits = 2;
  try
  {
    // .... processing...

    semaphore.acquire(1); // acquire one more permit (will block until Thread1 releases one)
    permits++;

    // ... print stuff
    System.out.println("2 2 2 2");

    // ... more processing      
  }
  catch (InterruptedException ie)
  {
    // interrupted
  }

  semaphore.release(permits); // release permits.
}