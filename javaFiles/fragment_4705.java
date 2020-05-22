import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 31/07/15.
 */
public class PacketSender {
    public static void main(String[] args) throws IOException {
        PacketSender ps = new PacketSender(InetAddress.getByName("localhost"), 12345);
        List<Client> clients = new ArrayList<>();
        for(int i=0;i<10;i++)
            clients.add(new Client());

        for(int t = 0; t< 3;t++) {
            long start = System.nanoTime();
            int tests = 100000;
            for (int i = 0; i < tests; i++) {
                ps.sendData(1234, 1, clients);
            }
            long time = System.nanoTime() - start;
            System.out.printf("Sent %,d messages per second%n", (long) (tests * 1e9 / time));
        }
    }


    final ThreadLocal<ByteBuffer> bufferTL = ThreadLocal.withInitial(() -> ByteBuffer.allocate(8192).order(ByteOrder.nativeOrder()));
    final ThreadLocal<DatagramSocket> socketTL;
    final ThreadLocal<DatagramPacket> packetTL;

    public PacketSender(InetAddress address, int port) {
        socketTL = ThreadLocal.withInitial(() -> {
            try {
                return new DatagramSocket(port, address);
            } catch (SocketException e) {
                throw new AssertionError(e);
            }
        });
        packetTL = ThreadLocal.withInitial(() -> new DatagramPacket(bufferTL.get().array(), 0, address, port));
    }

    public void sendData(int uid, int scale, List<Client> clients) throws IOException {
        ByteBuffer b = bufferTL.get();
        b.clear();
        b.putInt(uid);
        b.putInt(scale);
        b.putInt(clients.size());
        for (Client cl : clients) {
            b.putInt(cl.x);
            b.putInt(cl.y);
            b.putInt(cl.z);
            b.putInt(cl.rotation);
            b.putInt(cl.uid);
        }
        DatagramPacket dp = packetTL.get();
        dp.setData(b.array(), 0, b.position());
        socketTL.get().send(dp);
    }

    static class Client {
        int x,y,z,rotation,uid;
    }
}