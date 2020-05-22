try(
  ReadableByteChannel in=Channels.newChannel(
    new URL("http://example.com/update/PubApp_2.0.jar").openStream());
  FileChannel out=new FileOutputStream(
    "C:/PubApp_2.0/update/lib/kitap.jar").getChannel() ) {

  out.transferFrom(in, 0, Long.MAX_VALUE);
}