public void setCommSocket(DatagramPacket pkt, int port, DatagramSocket skt)
{
  comm_ip = pkt.getAddress();
  comm_port = pkt.getPort();
  synchronized(comm_pkt) {
    comm_pkt = pkt;
  }
  comm_skt = skt;
}