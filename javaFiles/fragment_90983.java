// ...    
synchronized(signal) {
   while(shouldWait) {
      signal.wait();
   }    
}