private void checkContentValueWithFile(File file, int[] byteRange, COSString contents) throws IOException
{
    // https://stackoverflow.com/questions/55049270
    // comment by mkl: check whether gap contains a hex value equal
    // byte-by-byte to the Content value, to prevent attacker from using a literal string
    // to allow extra space
    try (RandomAccessBufferedFileInputStream raf = new RandomAccessBufferedFileInputStream(file))
    {
        raf.seek(byteRange[1]);
        int c = raf.read();
        if (c != '<')
        {
            System.err.println("'<' expected at offset " + byteRange[1] + ", but got " + (char) c);
        }
        byte[] contentFromFile = raf.readFully(byteRange[2] - byteRange[1] - 2);
        byte[] contentAsHex = Hex.getString(contents.getBytes()).getBytes(Charsets.US_ASCII);
        if (contentFromFile.length != contentAsHex.length)
        {
            System.err.println("Raw content length from file is " +
                    contentFromFile.length +
                    ", but internal content string in hex has length " +
                    contentAsHex.length);
        }
        // Compare the two, we can't do byte comparison because of upper/lower case
        // also check that it is really hex
        for (int i = 0; i < contentFromFile.length; ++i)
        {
            try
            {
                if (Integer.parseInt(String.valueOf((char) contentFromFile[i]), 16) !=
                    Integer.parseInt(String.valueOf((char) contentAsHex[i]), 16))
                {
                    System.err.println("Possible manipulation at file offset " +
                            (byteRange[1] + i + 1) + " in signature content");
                    break;
                }
            }
            catch (NumberFormatException ex)
            {
                System.err.println("Incorrect hex value");
                System.err.println("Possible manipulation at file offset " +
                        (byteRange[1] + i + 1) + " in signature content");
                break;
            }
        }
        c = raf.read();
        if (c != '>')
        {
            System.err.println("'>' expected at offset " + byteRange[2] + ", but got " + (char) c);
        }
    }
}