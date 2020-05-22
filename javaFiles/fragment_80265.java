Socket socket = new Socket("172.16.4.23",5000);
String pathname = "/Users/Guest/Desktop/DQM.txt";
DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
outputStream.writeUTF(pathname);
FileInputStream fis = new FileInputStream(pathname);
int res = IOUtils.copy(fis, dos);
fis.close();
dos.close();
socket.close();