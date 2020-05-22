DataInputStream dis = new DataInputStream(socket.getInputStream());
String fileName = dis.readUTF();
FileOutputStream fos = new FileOutputStream(fileName);
int res = IOUtils.copy(dis, fos);
fos.close();
socket.close();