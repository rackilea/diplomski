readLock.lock(); //blocks writers only
try{
 if(!checkData()) //check if there's data, don't modify shared variables
 {
  readLock.unlock();
  writeLock.lock(); // need to lock the writeLock to allow to use the condition.
                    // only one reader will get the lock, other readers will wait here      
  try{
   while(!checkData()) // check if there' still no data
   {
     hasData.await(); //will unlock and re-lock after writer has signalled and unlocked.
   }
   readLock.lock();    // continue blocking writer
  }
  finally
  {
    writeLock.unlock(); //let other readers in
  }
 }
 //there should be data now
 readData(); // don't modify variables shared by readers.
}
finally
{
  readlock.unlock(); //let writers in
}