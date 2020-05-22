ServerSocket providerSocket;
Socket connection;
InetAddress addr;
try {
    addr = InetAddress.getByName(this.broker.getIP());
    providerSocket = new ServerSocket(this.broker.getPort(), 50, addr);
    while (true) {
        connection = providerSocket.accept();
        ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
        System.out.println(n.readUTF());
        in.close();
        out.close();
        connection.close();
    }
} catch (Exception err) {
      err.printStackTrace();
}