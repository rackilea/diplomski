public class OutputStreamMultiVolume extends OutputStream {

    private final long maxBytePerVolume;
    private long bytesInCurrentVolume = 0;
    private OutputStream out;
    private OutputStreamSupplier outputStreamSupplier;

    static interface OutputStreamSupplier {
        OutputStream get() throws IOException;
    }

    public OutputStreamMultiVolume(long maxBytePerOutput, OutputStreamSupplier outputStreamSupplier) throws IOException {
        this.outputStreamSupplier = outputStreamSupplier;
        this.maxBytePerVolume = maxBytePerOutput;
        this.out = outputStreamSupplier.get();
    }

    @Override
    public synchronized void write(byte[] bytes) throws IOException {
        final int remainingBytesInVol = (int) (maxBytePerVolume - bytesInCurrentVolume);
        if (remainingBytesInVol >= bytes.length) {
            out.write(bytes);
            bytesInCurrentVolume += bytes.length;
            return;
        }

        out.write(bytes, 0, remainingBytesInVol);
        switchOutput();

        this.write(bytes, remainingBytesInVol, bytes.length - remainingBytesInVol);
    }

    @Override
    public synchronized void write(int b) throws IOException {
        if (bytesInCurrentVolume + 1 <= maxBytePerVolume) {
            out.write(b);
            bytesInCurrentVolume += 1;
            return;
        }

        switchOutput();
        out.write(b);
        bytesInCurrentVolume += 1;
    }

    @Override
    public synchronized void write(byte[] b, int off, int len) throws IOException {
        final int remainingBytesInVol = (int) (maxBytePerVolume - bytesInCurrentVolume);
        if (remainingBytesInVol >= len) {
            out.write(b, off, len);
            bytesInCurrentVolume += len;
            return;
        }

        out.write(b, off, remainingBytesInVol);
        switchOutput();
        this.write(b, off + remainingBytesInVol, len - remainingBytesInVol);
        bytesInCurrentVolume += len - remainingBytesInVol;
    }

    private void switchOutput() throws IOException {
        out.flush();
        out.close();

        out = outputStreamSupplier.get();
        bytesInCurrentVolume = 0;
    }

    @Override
    public synchronized void close() throws IOException {
        out.close();
    }

    @Override
    public synchronized void flush() throws IOException {
        out.flush();
    }
}