FileChannel channel = new RandomAccessFile("/home/alain/Bureau/clair.txt", "r").getChannel();
    ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
    Charset chars = Charset.forName("ISO-8859-1");
    CharBuffer cbuf = chars.decode(buffer);
    String str = cbuf.subSequence(0, 10).toString();
    System.out.println("str = " + str);