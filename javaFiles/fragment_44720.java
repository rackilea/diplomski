solverTh = new Thread(new Runnable() {
    @Override
    public void run() {
        while(somethingistrue && 
              !Thread.currentThread().isInterrupted()) {
            try {
                //do lot of stuff here for long time
            } catch (InterruptedException ex) {
                // handle stop processing 
            }
        }
    }
});
solverTh.start();