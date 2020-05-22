public static void main(String[] args) {
    ClientModel c1 = new ClientModel ();
    c1.data = 123;
    c1.name = "test";

    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(c1);
      oos.flush();
      // get the byte array of the object
      byte[] Buf= baos.toByteArray();

      int number = Buf.length;;
      byte[] data = new byte[4];

      // int -> byte[]
      for (int i = 0; i < 4; ++i) {
          int shift = i << 3; // i * 8
          data[3-i] = (byte)((number & (0xff << shift)) >>> shift);
      }

      DatagramSocket socket = new DatagramSocket(1233);
      InetAddress client = InetAddress.getByName("localhost");
      DatagramPacket packet = new DatagramPacket(data, 4, client, 1234);
      socket.send(packet);

      // now send the payload
      packet = new DatagramPacket(Buf, Buf.length, client, 1234);
      socket.send(packet);

      System.out.println("DONE SENDING");
    } catch(Exception e) {
        e.printStackTrace();
    }
}