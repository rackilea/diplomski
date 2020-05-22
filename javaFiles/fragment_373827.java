use something like this,

while(true){
    Socket clientSocket = serverSocket.accept();
        new Thread(new Runnable() {
            @Override
            public void run() {
              login();
            }
        });
}