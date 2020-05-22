HandlerThread handlerThread = new HandlerThread("myHandlerThread");
    handlerThread.start();
    // Now get the Looper from the HandlerThread so that we can create a Handler that is attached to
    // the HandlerThread
    // NOTE: This call will block until the HandlerThread gets control and initializes its Looper
    Looper looper = handlerThread.getLooper();
    // Create a handler attached to the background message processing thread
    handler = new Handler(looper, this);