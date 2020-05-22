public List<Runnable> shutdownNow() {
...
        checkShutdownAccess();
        advanceRunState(STOP);
        interruptWorkers();
        tasks = drainQueue();
...
}