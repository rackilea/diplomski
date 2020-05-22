private static int LOCALPORT = 0;
private static String TARGETIP = "88.888.88.888";
private static int TARGETPORT = 8888;
try{
    InetAddress serverAddr = InetAddress.getByName(TARGETIP);
    socket = new Socket(serverAddr, TARGETPORT);
    LOCALPORT = socket.getLocalPort();
    //socket.close();
    socket.setReuseAddress(true);
    ServerSocket sSocket = new ServerSocket(LOCALPORT);
    Socket skt = sSocket.accept();
    sSocket.close();
}
catch (IOException e){
    e.getMessage();
    e.printStackTrace();
}