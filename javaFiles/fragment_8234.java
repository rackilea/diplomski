import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) {
        if( args.length == 0 ) runClient();
        if(args[0].equals("s")) runServer();
        else runClient();
    }

    static String mcastAddr = "239.255.100.100";  // Chosen at random from local network block at http://www.iana.org/assignments/multicast-addresses/multicast-addresses.xhtml
    static int port = 4446;

    public static void runServer() {
        while (true) {
            try {
                MulticastSocket s = new MulticastSocket(port);
                InetAddress group = InetAddress.getByName(mcastAddr);
                s.joinGroup(group);

                byte[] recData = new byte[100];
                DatagramPacket receivePacket = new DatagramPacket(recData, recData.length);
                s.receive(receivePacket);
                String strrec = new String(recData,0,receivePacket.getLength());
                print("server received: " + strrec);
                print("from: " + receivePacket.getAddress().toString());

                if(strrec.equals("Are you there?")) {
                    String msg = "Here I am";
                    byte[] msgData = msg.getBytes();
                    DatagramPacket msgPacket = new DatagramPacket(msgData, msgData.length, receivePacket.getAddress(), receivePacket.getPort());
                    s.send(msgPacket);
                    print("server sent: " + msg + "\n");
                } else {
                    print("Didn't send; unrecognized message.");
                }


            } catch (Exception e) {
                print(e.toString());
            }
        }
    }

    public static void runClient() {
        try {
            DatagramSocket s = new DatagramSocket();

            String msg = "Are you there?";  // Magic string
            byte[] msgData = msg.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(msgData, msgData.length, InetAddress.getByName(mcastAddr), port);
            s.send(datagramPacket);
            print("client sent: " + msg);

            byte[] recData = new byte[100];
            DatagramPacket receivePacket = new DatagramPacket(recData, recData.length);
            s.receive(receivePacket);
            String strrec = new String(recData,0,receivePacket.getLength());
            print("client received: " + strrec);
            print("from " + receivePacket.getAddress().toString() + " : " + receivePacket.getPort());

            System.exit(0);
        } catch (Exception e) {
            print(e.toString());
        }
    }
    static void print(String s) {             System.out.println(s);         }
}