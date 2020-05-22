import java.net.InetAddress;
import java.nio.ByteBuffer;

// Convert from an IPv4 address to an integer
InetAddress from_inet = InetAddress.getByName("192.168.1.50");
int from_address = ByteBuffer.wrap(from_inet.getAddress()).getInt();


// Convert from an IPv4 address to an integer
InetAddress to_inet = InetAddress.getByName("192.169.1.12");
int to_address = ByteBuffer.wrap(to_inet.getAddress()).getInt();


for(int i = from_address; i < to_address; i++) {
    // Convert from integer to an IPv4 address
    InetAddress foo = InetAddress.getByName(i);
    String address = foo.getHostAddress();
    System.out.println(address);
}