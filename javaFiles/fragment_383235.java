try {
  BufferedInputStream in = new java.io.BufferedInputStream(new URL(link).openStream());
  FileOutputStream fos = new FileOutputStream(destination);
  BufferedOutputStream bout = new BufferedOutputStream(fos,1024);

  byte data[] = new byte[1024];
  int count;

  while( (count = in.read(data,0,1024)) != -1){
    bout.write(data,0,count);
  }

  bout.flush();
  bout.close();

  in.close();

} catch(Throwable t){
  t.printStackTrace();
}