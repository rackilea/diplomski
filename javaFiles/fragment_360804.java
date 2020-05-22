try
{
  Semaphore semaphore = new Semaphore(4); // 4 permit semaphore

  Thread1 thread1 = new Thread1(semaphore);
  Thread2 thread2 = new Thread2(semaphore);

  thread1.start();
  thread2.start();

  semaphore.acquire(4);
}
catch (InterruptedException ie)
{
  // interrupt logic...
}