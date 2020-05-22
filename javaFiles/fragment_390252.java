DatagramSocket s;

    try {
        s = new DatagramSocket();
        byte[] buf = new byte[1000];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        InetAddress hostAddress = InetAddress.getByName("localhost");

        String outString = "Say hi";        // message to send
        buf = outString.getBytes();

        DatagramPacket out = new DatagramPacket(buf, buf.length, hostAddress, 9999);
        s.send(out);        // send to the server

        s.setSoTimeout(1000);   // set the timeout in millisecounds.

        while(true){        // recieve data until timeout
            try {
                s.receive(dp);
                String rcvd = "rcvd from " + dp.getAddress() + ", " + dp.getPort() + ": "+ new String(dp.getData(), 0, dp.getLength());
                System.out.println(rcvd);
            }
            catch (SocketTimeoutException e) {
                // timeout exception.
                System.out.println("Timeout reached!!! " + e);
                s.close();
            }
        }

    } catch (SocketException e1) {
        // TODO Auto-generated catch block
        //e1.printStackTrace();
        System.out.println("Socket closed " + e1);

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }