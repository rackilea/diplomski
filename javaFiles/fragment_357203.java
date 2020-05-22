public class MyInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(final ReaderInterceptorContext context) throws IOException, WebApplicationException {
        final InputStream old = context.getInputStream();
        final String first = context.getHeaders().getFirst("Content-Length");
        final Long declared = first == null ? -1 : Long.valueOf(first);

        context.setInputStream(new InputStream() {

            private long length = 0;
            private int mark = 0;

            @Override
            public int read() throws IOException {
                final int read = old.read();
                readAndCheck(read != -1 ? 1 : 0);
                return read;
            }

            @Override
            public int read(final byte[] b) throws IOException {
                final int read = old.read(b);
                readAndCheck(read != -1 ? read : 0);
                return read;
            }

            @Override
            public int read(final byte[] b, final int off, final int len) throws IOException {
                final int read = old.read(b, off, len);
                readAndCheck(read != -1 ? read : 0);
                return read;
            }

            @Override
            public long skip(final long n) throws IOException {
                final long skip = old.skip(n);
                readAndCheck(skip != -1 ? skip : 0);
                return skip;
            }

            @Override
            public int available() throws IOException {
                return old.available();
            }

            @Override
            public void close() throws IOException {
                old.close();
            }

            @Override
            public synchronized void mark(final int readlimit) {
                mark += readlimit;
                old.mark(readlimit);
            }

            @Override
            public synchronized void reset() throws IOException {
                this.length = 0;
                readAndCheck(mark);
                old.reset();
            }

            @Override
            public boolean markSupported() {
                return old.markSupported();
            }

            private void readAndCheck(final long read) {
                this.length += read;

                if (this.length > declared) {
                    throw new WebApplicationException(
                            Response.status(Response.Status.LENGTH_REQUIRED)
                                    .entity("No content-length provided.")
                                    .build());
                }
            }
        });

        final Object entity = context.proceed();

        context.setInputStream(old);

        return entity;
    }
}