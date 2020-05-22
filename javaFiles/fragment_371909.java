public class Clientclass extends Thread {

Socket socket;
String host_address;

public Clientclass(InetAddress hostaddress){

    host_address=hostaddress.getHostAddress();
    socket=new Socket();
}

@Override
public void run() {

    try {
        socket.connect(new InetSocketAddress(host_address,1111),500);

    sendRecieve=new SendRecieve(socket);
    sendRecieve.start();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}