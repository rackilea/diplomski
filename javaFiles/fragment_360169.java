socket = server.accept();

DataInputStream dis = new DataInputStream(socket.getInputStream());
String name = dis.readUTF();
File file = new File(_downloadDir, name);
long fileSize = dis.readLong();
System.out.println("Saving " + file + " from user... ("
        + fileSize + " bytes)");