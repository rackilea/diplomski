class FileUpdater {
    private static final long MAX_SIZE = 64 * 1024;
    private static final byte[] NO_BYTES = {};

    private final FileInputStream in;
    private long readSoFar = 0;

    public FileUpdater(File file) throws FileNotFoundException {
        this.in = new FileInputStream(file);
    }

    public byte[] read() throws IOException {
        long size = in.getChannel().size();
        long toRead = size - readSoFar;
        if (toRead > MAX_SIZE)
            toRead = MAX_SIZE;
        if (toRead == 0)
            return NO_BYTES;
        byte[] bytes = new byte[(int) toRead];
        in.read(bytes);
        readSoFar += toRead;
        return bytes;
    }    
}