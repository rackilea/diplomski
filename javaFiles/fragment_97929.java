synchronized (controllerLock)  {
    jobList[index] = false;    // Tell world this thread is done.
    for (boolean active : jobList)
        if (active)
            // Another thread is still running.
            return;
    // This was the last thread. We're done. Restart controller.
    controllerLock.notifyAll();
}