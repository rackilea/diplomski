FileLock lock;
FileChannel channel;
try
{
  channel = myOutputStream.getChannel();
  lock = channel.lock(); // This is a blocking lock, also consider tryLock()
  // ... write your data
} catch (Exception e)
{

} finally
{
  lock.release();
  channel.close();
}