// synchronizing with other clients...
// now we're at the critical section.  Block until we have the lock
Shared.mutex.acquireUninterruptibly();
// update state
Shared.mutex.release();
// critical section over.  Schedule an update on the GUI thread.