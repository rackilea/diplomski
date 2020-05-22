// now we communicate all worker threads should stop
    control.announceDone();

    // wait for all workers to transit to teardown
    control.awaitWarmdownReady();

    // Wait for the result, handling timeouts
    while (completed.size() < numThreads) {