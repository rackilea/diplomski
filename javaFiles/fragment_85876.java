public class Operator {

    public void newOperation(final SocketChannel socketChannel) throws IOException {
        DataInputStream dis = new DataInputStream(socketChannel.socket().getInputStream());
        DataOutputStream dos = new DataOutputStream(socketChannel.socket().getOutputStream());
        //TODO something here
        dis.close();
        dos.close();
        socketChannel.close();
    }

}