Thread t1 = new Thread(new Runnable() {
    public void run(){
        Client client = new Client("127.0.0.1");
        client.startRunning();
    }
});  
t1.start();