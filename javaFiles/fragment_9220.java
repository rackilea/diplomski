class CachedHttpInputMessage implements HttpInputMessage {
    private final HttpInputMessage httpInputMessage;
    private ByteArrayOutputStream outputStream;

    CachedHttpInputMessage(final HttpInputMessage httpInputMessage) {
        this.httpInputMessage = httpInputMessage;
    }

    @Override
    public InputStream getBody() throws IOException {
        if (outputStream == null) {
            outputStream = new ByteArrayOutputStream();

            final InputStream body = httpInputMessage.getBody();
            final byte[] buffer = new byte[1024];

            while (true) {
                final int length;
                if (!((length = body.read(buffer)) > -1)) {
                    break;
                }

                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();
        }

        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    @Override
    public HttpHeaders getHeaders() {
        return httpInputMessage.getHeaders();
    }
}