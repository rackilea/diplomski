public class CachedImage {
    private static final int BUFFER_SIZE = 32768; // 32k buf
    byte[] data;
    int toSend;

    public CachedImage(int toSend, InputStream is) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        while (is.read(buffer) != -1) {
            os.write(buffer);
        }
        data = os.toByteArray();
    }
}