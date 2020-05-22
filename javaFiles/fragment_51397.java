private static AtomicInteger count = new AtomicInteger(0);

public void onMessage(Message message)
{
  String oldName = Thread.currentThread().getName();
  Thread.currentThread.setName("my-thread-" + count.getAndIncrement())

  try
  {
    // ... existing code ...
  }
  finally
  {
    Thread.currentThread().setName(oldName);
  }
}