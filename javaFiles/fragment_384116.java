baiss = csocket.getInputStream();
int count = baiss.read(receiveData);
if(count == -1){
    isRunning = false;
    sockets.remove(csocket);
    System.out.println("socket closed!");
}
// ...
os = client.getOutputStream();
os.write(receiveData, 0, count);