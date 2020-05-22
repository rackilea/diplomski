static final class ISS implements Supplier<InputStream> {
    final InputStream in;
    GZIPInputStream gz;
    ISS(InputStream in) {
        this.in = in;
    }
    public synchronized InputStream get() {
        if (gz == null) {
            try {
                gz = new GZIPInputStream(in);
            } catch (IOException t) {
                throw new UncheckedIOException(t);
            }
        }
        return gz;
    }
}