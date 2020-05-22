ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(baos);
oos.writeObject(stub);
oos.close();
byte[] bytes = baos.toByteArray();
DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, target, port);
// etc ... send this datagram