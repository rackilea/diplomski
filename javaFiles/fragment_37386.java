Socket socket = new Socket("ipaddress_of_machine", SHARED_PORT);
OutputStream oStream = new BufferedOutputStream(socket.getOutputStream());
File file = new File("Path_to_File");
InputStream iStream = new FileInputStream(file);
byte[] buffer = new byte[8192];
for(int readCount = iStream.read(buffer); readCount != -1; readCount = iStream.read(buffer)) {
   oStream.write(buffer, 0, readCount);
}
oStream.flush();
oStream.close();
iStream.close();