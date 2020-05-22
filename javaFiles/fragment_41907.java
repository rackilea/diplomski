public class UDP {

    public static void main(String[] args) throws Exception {
        final String nodeName = args[0];
        final int ownPort = Integer.valueOf(args[1]);
        final int neighbourPort1 = Integer.valueOf(args[2]);
        final int neighbourPort2 = Integer.valueOf(args[3]);


        // Don't create a new socket every time
        DatagramSocket neighbour1 = new DatagramSocket();
        DatagramSocket neighbour2 = new DatagramSocket();

        neighbour1.connect(InetAddress.getLocalHost(), neighbourPort1);
        neighbour2.connect(InetAddress.getLocalHost(), neighbourPort2);

        // You have to LISTEN
        new Thread() {
            @Override
            public void run() {
                try {
                    DatagramSocket socket = new DatagramSocket(ownPort);

                    byte[] buffer = new byte[socket.getReceiveBufferSize()];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                    while (true) {
                        // Blocks until it gets a packet
                        socket.receive(packet);

                        System.out.println("Received string");
                    }

                    // socket.close();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        while (true) {
            Thread.sleep(3000);

            sendPacket(neighbour1, nodeName);
            sendPacket(neighbour2, nodeName);
        }

        // If you're not using an infinite loop:
        // neighbour1.close();
        // neighbour2.close();
    }

    private static void sendPacket(DatagramSocket to, String from) throws Exception {
        String message = "Hello I'm " + from;
        byte[] data = message.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length);
        to.send(packet);
    }

}