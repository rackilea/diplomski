try{
  byte [] buf  = new byte [1024];

  FileOutputStream fos = new FileOutputStream(file);
  InputStream is = socket.getInputStream();
  BufferedInputStream bis = new BufferedInputStream(is);

  InputStreamReader isr = new InputStreamReader(bis);
  String file = isr.readLine(); // Read filename

  DataInputStream dis = new DataInputStream(bos);
  long fileSize = dis.readLong(); // Read Filesize 

  int count = 0;
  while ((fileSize > 0) && (count = bis.read(buf, 0, (int)Math.min(buf.length, fileSize))) > 0){
    fos.write(buf, 0, count);
    fileSize -= count;
  }

  fos.close();
}catch(IOException e){
  e.printStackTrace();
}