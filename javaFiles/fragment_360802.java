public void run()
{
  // .... processing...

  // ... print stuff
  System.out.println("1 1 1 1");
  semaphore.release(); // release 1 permit, allowing thread2 to continue

  // ... more processing

  semaphore.release(); // release last permit.
}