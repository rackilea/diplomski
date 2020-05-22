Thread thread = new Thread(...);
// thread has the daemon status of the current thread
// so we have to override it if we want to change that
thread.setDaemon(true);
// we need to set the daemon status _before_ the thread starts
thread.start();