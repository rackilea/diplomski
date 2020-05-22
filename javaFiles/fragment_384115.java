baiss = csocket.getInputStream();
if(csocket.isClosed()||!csocket.isConnected()){
    isRunning = false;
    sockets.remove(csocket);
    System.out.println("socket closed!");
}
baiss.read(receiveData);
// ...
os = client.getOutputStream();
os.write(receiveData,0,1280);