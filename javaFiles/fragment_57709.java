static DatagramSocket socket2;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Open my own server part to listen messages from broadcast returned
        listen();
        // Sending UDP broadcast in this part as question implied
    }
    public static void listen() {
        new Thread() {
            public void run() {
                try{
                    socket2 = new DatagramSocket(10000);
                    socket2.setBroadcast(true);
                    byte[] recvBuf = new byte[1024];

                    while (true) {
                        DatagramPacket packet2 = new DatagramPacket(recvBuf, recvBuf.length);
                        try{
                            socket2.receive(packet2);
                            System.out.println("Discovery packet received from: " + packet2.getAddress().getHostAddress());
                            System.out.println("Packet received; data: " + new String(packet2.getData()));
                            String message = new String(packet2.getData());
                            System.out.println("Received: "+message);

                        }catch(Exception ex){
                            System.out.println("Cannot receive package: " + ex.getMessage());
                        }
                    }
                }catch(Exception ex){
                    socket2.close();
                    System.out.println("Server side problem occured: " + ex.getMessage());
                }
            }
        }.start();
    }