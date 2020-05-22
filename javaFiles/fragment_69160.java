ByteArrayOutputStream bos = new ByteArrayOutputStream(in.available());
 byte[] buf = new byte[4096*16];
 int c;
 while((c=in.read(buf))!=-1){
     bos.write(buf, 0, c);
 }
 byte[] data = bos.toByteArray();