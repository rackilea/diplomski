public class FileBodyCounter extends FileBody {
    private volatile long byteCount;

    public long getBytesWritten() {
        return byteCount;
    }

    public void writeTo(OutputStream out) {
        super.writeTo(new FilterOutputStream(out) {
            // Other write() methods omitted for brevity. Implement for better performance
            public void write(int b) throws IOException {
                byteCount++;
                super.write(b);
            }
        });
    }
}