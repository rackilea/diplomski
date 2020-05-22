public class UDPServer {
    public void send(final String sendID, final int val) throws Exception {

            final DatagramSocket serverSocket = new DatagramSocket(7474);
            byte[] sendData = new byte[1024];
            final InetAddress IPAddress = InetAddress.getLocalHost();
            final String sentence = sendID + new String(" ")
                  + new Integer(val).toString();
            final String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            final DatagramPacket sendPacket = new DatagramPacket(sendData,
                  sendData.length, IPAddress, 7470);
            serverSocket.send(sendPacket);
     }
}