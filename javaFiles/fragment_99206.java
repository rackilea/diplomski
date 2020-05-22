import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Receives UDP broadcast packets in the default port requesting for server name
 * and IP, broadcasting the information in return.
 * 
 * @author jfacorro
 * 
 */
public class NameResolverService extends Thread {

    private InetAddress localAddress = null;
    private byte[] localAddressData = null;
    private MulticastSocket socket = null;
    private boolean exit = false;

    public NameResolverService() {
    }

    public void exit() {
        this.exit = true;
        this.socket.close();
    }

    @Override
    public void run() {
        try {
            int port = 4444;
            String multicastAddr = "224.168.1.0";

            // Get current address
            this.localAddress = InetAddress.getLocalHost();

            this.socket = new MulticastSocket(port);
            InetAddress group = InetAddress.getByName(multicastAddr);
            this.socket.joinGroup(group);
            this.localAddressData = (this.localAddress.getHostAddress() + ";" + this.localAddress
                    .getHostName()).getBytes();

        } catch (IOException ex) {
            this.notified.notified(ex.getMessage());
            ex.printStackTrace();
        }

        while (!this.exit) {
            try {
                byte[] buffer = new byte[1];
                DatagramPacket packet = new DatagramPacket(buffer,
                        buffer.length);

                socket.receive(packet);

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(this.localAddressData,
                        this.localAddressData.length, address, port);

                socket.send(packet);

            } catch (IOException e) {
                if(!this.exit)
                    e.printStackTrace();
            }
        }

        this.socket.close();
    }
}