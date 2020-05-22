String cmd("my command");
    try {
        InetSocketAddress address = new InetSocketAddress("10.1.1.1", 12350);
        DatagramPacket request = new DatagramPacket(cmd.getBytes(), cmd.length(), address);
        DatagramSocket socket = new DatagramSocket();
        socket.send(request);
    } catch (SocketException e) {

        ...
        }
    } catch (IOException e) {

       ...
        }
    }