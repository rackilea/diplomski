class MyCharSequence implements CharSequence {

    public MyCharSequence(File file, Charset cs, int bufferSize) throws IOException {

        FileInputStream input = new FileInputStream(file);
        FileChannel channel = input.getChannel();
        this.fileLength = (int) channel.size();
        this.bytes = channel.map(FileChannel.MapMode.READ_ONLY, 0, fileLength);
        this.charBuffer = CharBuffer.allocate(bufferSize);
        this.decoder = cs.newDecoder();

    }

    public int length() {
        // ouch! have to decode the lot, even if you don't choose to keep it all handy
    }

    public char charAt(final int index) {
        while ( /* not yet decoded target char[] */ )  {
            this.decoder.decode(this.bytes, this.charBuffer, true);
        }
        // don't assume 2-bytes == a char unless that's true for your charset!
    }

    public CharSequence subSequence(final int start, final int end) {
        // this'll be fun, too
    }

    private long fileLength;
    private MappedByteBuffer bytes;
    private CharBuffer charBuffer;
    private CharsetDecoder decoder;

}