// Thread2 would be identical wrt the semaphore
public Thread1(Semaphore semaphore) throws InterruptedException
{
  this.semaphore = semaphore; // store semaphore locally
  semaphore.acquire(2);
}