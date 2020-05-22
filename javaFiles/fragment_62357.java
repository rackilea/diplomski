public class DataPacket {
    final DatagramSocket serverSocket;

    public DataPacket(InetAddress address, int port) throws SocketException {
        this.serverSocket = new DatagramSocket(port, address);
    }

    public void send(String message) throws IOException {
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        serverSocket.send(new DatagramPacket(bytes, bytes.length));
        System.out.println("Sent " + message);
    }
}