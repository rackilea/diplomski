private static volatile int connectedClients = 0;
private static final Object lock = new Object();
public static void callBack () throws Exception{
    //....
           ch.pipeline().addLast(new RequestDataEncoder(), new ResponseDataDecoder(),
                                 new ClientHandler(i -> {
               synchronized (lock) {
                   connectedClients = i;
                   lock.notifyAll();
               }
           });
    //....
}

public static void main(String[] args) throws Exception {

  callBack();
  int connected = connectedClients;
  if (connected != 2) {
      System.out.println("The number if the connected clients is not two before locking");
      synchronized (lock) {
          while (true) {
              connected = connectedClients;
              if (connected == 2)
                  break;
              System.out.println("The number if the connected clients is not two");
              lock.wait();
          }
      }
  }
  System.out.println("The number if the connected clients is two: " + connected );
}