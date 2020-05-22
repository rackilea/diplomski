Semaphore s = new Semaphore(0, true); // No permits to start with, acquire will block

// Producer loop
makeNewDataAvailable();
s.release();  // Raise "flag" to indicate new info
possiblyDoSomethingUseful();
s.acquire();  // A fair semaphore, so waiting threads get the permit

// Consumer loop
s.acquire();  // Blocks until "flag" raised, then acquires it
processNewData();
s.release();  // Pass the permit back to thread 1