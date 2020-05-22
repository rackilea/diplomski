InputStream in = socket.getInputStream();
int bytesRead;
byte[] bytes = new bytes[512];
while((bytesRead = in.read(bytes)) > 0) {
   for (int i =0; i < bytesread; i++) {
       int bi = bytesRead[i] & 0xFF;
       System.out.println(bi);
   }
}