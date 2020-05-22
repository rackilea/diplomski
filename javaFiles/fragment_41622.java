Set<String> threadsToMonitoryByName = ... 

while (! threadsToMonitoryByName.empty() ) {
  for (String threadName : threadsToMonitorByName) { 
     Thread thread = getThreadByName( threadName );
       if ( thread != null ) {
         while ( thread.isAlive() ) {
            thread.join();
            threadsToMonitorByName.remove(threadName);
         }
      }
  }
  // and probably some thread sleeping here to avoid HOT waiting
  ...
}