class TIME implements Runnable {
private volatile boolean isRunning = true;
    @Override
    public void run() {

       while (isRunning){
           // do some work here
       }
    }

    public void killMe(){
       isRunning=false;
    }
}