public class TcpPacket {

private static int header_start =  0x55AA;

private static int protocol_version = 1;

private PacketUtils packetUtils = new PacketUtils();






 public byte[] getHandshakePacket()
 {
    int request_id = 1;

    byte[] header_data = packetUtils.ItoBA2(header_start);
    byte[] payload_data = packetUtils.ItoBA4(packetUtils.getDateTime());
    byte[] payload_length = packetUtils.ItoBA2(4);


    byte[] a_data = new byte[]{header_data[0], header_data[1], (byte) protocol_version, packetUtils.getDSN(), (byte) request_id, payload_length[0], payload_length[1],
            payload_data[0], payload_data[1], payload_data[2], payload_data[3]};

    byte[] b_data = new byte[]{ packetUtils.getCRC(a_data)};

    byte[] packet_data = packetUtils.concatBytes(a_data,b_data);


    return packet_data;
 }

}