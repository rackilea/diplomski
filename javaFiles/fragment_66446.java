private void updateTable(){ 

    Task<Void> myUpdatingTask=new Task<Void>() {
       @Override
       protected Void call() throws Exception {
        //Your Updating Code Here
       }
    }

    //and then you run it like this:
    Thread hilo=new Thread(myUpdatingTask);
    hilo.setDaemon(true);
    hilo.start();
}