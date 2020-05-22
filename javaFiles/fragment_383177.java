public static void timeNioReader () throws IOException {
    long bef = System.currentTimeMillis();

    File file = new File("/Users/stu/test.txt");
    FileChannel fc = (new FileInputStream(file)).getChannel(); 
    MappedByteBuffer buf = fc.map(MapMode.READ_ONLY, 0, file.length());
    boolean emptyLine = true;
    int     counter = 0;

    while (buf.hasRemaining())
    {
        byte element = buf.get();

        if (element == '\r' || element == '\n') {
            if (!emptyLine) {
                counter += 1;
                emptyLine = true;
            }
        } else 
            emptyLine = false;

    }

    long after = System.currentTimeMillis() - bef;

    System.out.println("timeNioReader      Time: " + after + " Result: " + counter);

}