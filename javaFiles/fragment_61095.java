public class Client {
    private static void sendToServer(String ipAddress, int port) throws UnknownHostException, IOException {
        Socket socket = new Socket(ipAddress, port);

        // same here, only open one stream
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        File f = new File("C:/Users/lukeLaptop/Downloads/RemoveWAT22.zip");
        String data = f.getName()+f.length();

        dos.writeUTF(data);

        dos.flush();
        dos.close();    
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        Client.sendToServer("localhost", 8081);
    }
}