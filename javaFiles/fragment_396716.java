public static String readFile(File f, int bufSize) {
    ReadableByteChannel rbc = FileChannel.open(Paths.get(f),StandardOpenOption.READ);
    char[] ca = new char[bufSize];
    ByteBuffer bb = ByteBuffer.allocate(bufSize);
    StringBuilder sb = new StringBuilder();
    while(rbc.read(bb) > -1) {
        CharBuffer cb = bb.asCharBuffer();
        cb.flip();
        cb.get(ca);
        sb.append(ca);
        cb.clear();
    }
    return sb.toString();
}