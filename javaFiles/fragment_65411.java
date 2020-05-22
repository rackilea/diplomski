MyHTTPTransaction thread = new MyHTTPTransaction(.....);
thread.start();
thread.join(5000);
/* check if the thread has completed or is still hanging. If it's hanging: */
    thread.abortNow();
/* else tell the user everything went fine */