haveAnswer:  {
    if (foundIt)  break haveAnswer;   // Already found by another thread.
    synchronized (threadLock)  {
        // Only one thread at a time can get into this block.
        if (foundIt)  break haveAnswer;   // Found since previous check.
        foundIt = true;
    }
    // Add code here to put answer in right place.
    // Only one thread will get this far.
}