...
if (timeToShutDown()) {
    Executors.newSingleThreadExecutor.execute(new Runnable() {

        public void run() {
            stopTheContainer();
        }
    }
 }
 // exit the listener so the container can actually stop.