File fileToSend = //...
InputStream in = new FileInputStream(fileToSend);
OutputStream out = //...
byte buffer[] = new byte[PACKET_SIZE];
int read;
while ((read = in.read(buffer)) != -1){
  out.write(buffer, 0, read);
}
in.close();
out.close();