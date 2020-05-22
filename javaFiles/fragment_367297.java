public class PeerWrapper {

    private InetAddress ipaddress;
    private Integer port;
    private Socket client_socket;
    private InetAddress comm_ip;
    private DatagramSocket comm_skt;
    private DatagramPacket comm_pkt;
    private int comm_port;
    private byte status;