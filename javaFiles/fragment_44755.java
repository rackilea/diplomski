HandlerThread handlerThread = new HandlerThread("myHandlerThread");
    handlerThread.start();
    Looper looper = handlerThread.getLooper();
    // Create an instance of the class that will handle the messages that are posted
    //  to the Handler
    Worker worker = new Worker();
    // Create a Handler and give it the worker instance to handle the messages
    handler = new Handler(looper, worker);