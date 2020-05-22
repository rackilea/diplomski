Thread t = new Thread(new Runnable(){
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            //do stuff
            try{
                Thread.sleep(TIME_TO_SLEEP);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt(); //propagate interrupt
            }
        }
    }
});
t.start();