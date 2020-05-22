public class UDPDataExchange {

String Hostname;
static InetAddress IPAddress;

UDPDataExchange() {
    Hostname = new String("127.0.0.1");
    try {
        IPAddress = InetAddress.getLocalHost();
    } catch (final UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public void requestData(final int portNumber, final String data) {
    try {
        final DatagramSocket clientSocket = new DatagramSocket();
        final byte[] receiveData = new byte[1024];
        final DatagramPacket receivePacket = new DatagramPacket(receiveData,
                receiveData.length);
        byte[] sendData = new byte[1024];
        sendData = data.getBytes();
        System.out.print("Ready to send data ");
        final DatagramPacket sendPacket = new DatagramPacket(sendData,
                sendData.length, IPAddress, portNumber);
        clientSocket.send(sendPacket);
        clientSocket.setSoTimeout(10000);
        try {
            clientSocket.receive(receivePacket);
            final String modifiedSentence = new String(receivePacket.getData());

            final InetAddress returnIPAddress = receivePacket.getAddress();

            final int port = receivePacket.getPort();

            System.out.println("From server at: " + returnIPAddress + ":"
                    + port);
            System.out.println("Message: " + modifiedSentence);

        } catch (final SocketTimeoutException ste) {
            System.out.println("Timeout Occurred: Packet assumed lost");
        }
        // clientSocket.close();

    } catch (final SocketException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (final IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

public void responseData(final int portNumber) {
    try {

        final DatagramSocket serverSocket = new DatagramSocket(portNumber, IPAddress);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {

            receiveData = new byte[1024];

            final DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);

            System.out.println("Waiting for datagram packet");

            serverSocket.receive(receivePacket);

            final String sentence = new String(receivePacket.getData());

            final InetAddress IPAddress = receivePacket.getAddress();

            final int port = receivePacket.getPort();

            System.out.println("From: " + IPAddress + ":" + port);
            System.out.println("Message: " + sentence);

            final String capitalizedSentence = sentence.toUpperCase();

            sendData = capitalizedSentence.getBytes();

            final DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);

        }

    } catch (final SocketException ex) {
        System.out.println("UDP Port 9876 is occupied.");
        System.exit(1);
    } catch (final IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

}