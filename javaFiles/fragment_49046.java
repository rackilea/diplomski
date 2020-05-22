InputStream inflInstream = new InflaterInputStream(new ByteArrayInputStream(inputData.getBytes()), 
                                                   new Inflater(true));

byte bytes[] = new byte[1024];
while (true) {
    int length = inflInstream.read(bytes, 0, 1024);
    if (length == -1)  break;

    System.out.write(bytes, 0, length);
}