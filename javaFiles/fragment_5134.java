// At this point you have one thread (there may be more,
// but suppose it's only one).
// The thread is executing the code below.

ConnectedThread connectedThread = new ConnectedThread(socket);
connectedThread.start();

// Now you have two threads running simultaneously.
// The new thread is doing whatever the run() method defined in
// ConnectedThread,
// that is that infinite loop with read() calls.
// But this thread goes on.

connectedThread.write();

// The write() call above is executed in this thread,
// which has nothing to do with
// the run() defined in ConnectedThread.