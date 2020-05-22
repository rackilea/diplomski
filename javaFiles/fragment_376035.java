final SynchronousQueue<Handler> giveMeHandler = new SynchronousQueue();
    new Thread(new Runnable(){
       public void run(){
          Handler handler;
          // create a Handler;
          giveMeHandler.put(handler); // blocks until handler taken;
       }

    }).start();

    Handler handler = giveMeHandler.take(); // blocks until handler given