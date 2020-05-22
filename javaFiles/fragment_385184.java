class ConnectThread implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
                   //Do Stuff 
                   if(finish){ 
                       //stop the thread and start the other passing variables
                       //Use this to stop the thread
                       Thread.currentThread().interrupt();
                    } 
}