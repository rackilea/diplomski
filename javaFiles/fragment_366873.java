// if the critical section is free, check for updated state.  Else, just wait
if (Shared.mutex.tryAcquire())  {
   try {
     // read state and update GUI
   } finally {
     Shared.mutex.release();
   }
}