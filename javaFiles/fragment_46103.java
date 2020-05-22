public static void main(String[] args) {
    try {
      DatagramSocket socket = new DatagramSocket(1234);

      byte[] data = new byte[4];
      DatagramPacket packet = new DatagramPacket(data, data.length );
      socket.receive(packet);

      int len = 0;
      // byte[] -> int
      for (int i = 0; i < 4; ++i) {
          len |= (data[3-i] & 0xff) << (i << 3);
      }

      // now we know the length of the payload
      byte[] buffer = new byte[len];
      packet = new DatagramPacket(buffer, buffer.length );
      socket.receive(packet);

        ByteArrayInputStream baos = new ByteArrayInputStream(buffer);
      ObjectInputStream oos = new ObjectInputStream(baos);
      ClientModel c1 = (ClientModel)oos.readObject();
      c1.print();
    } catch(Exception e) {
        e.printStackTrace();
    }
}