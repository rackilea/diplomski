ExecutorService exec = Executors.newFixedThreadPool(1);//A field somewhere
    //Start your thread
    exec.submit(new Runnable(){
        @Override
        public void run() {
            while (!exec.isShutdown()) {
                Log.d(TAG, "Running...");
                //Do stuff
            }
        }
    });
    //when done
    exec.shutdown();