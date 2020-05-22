public static RequestBody createBody(final MediaType contentType, final ParcelFileDescriptor fd) {
    if (fd == null) throw new NullPointerException("content == null");

    return new RequestBody() {
        @Override public MediaType contentType() {
            return contentType;
        }

        @Override public long contentLength() {
            return fd.getStatSize();
        }

        @Override public void writeTo(BufferedSink sink) throws IOException {
            Source source = null;
            try {
                source = Okio.source(new ParcelFileDescriptor.AutoCloseInputStream(fd));
                sink.writeAll(source);
            } finally {
                Util.closeQuietly(source);
            }
        }
    };
}