int n = 10;

      // Create the socket
      int port = 1502;
      DatagramSocket socket;
      byte[] buf = new byte[1000];
      DatagramPacket packet = new DatagramPacket(buf, buf.length);

      socket = new DatagramSocket(port);

      for (int i = 0; i < n; i++)
      {
          socket.receive (packet);
          byte[] numb = packet.getData();
          int num = ByteBuffer.wrap(numb).getInt();
          System.out.println(Integer.toString(num));
      }