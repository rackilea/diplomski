final ByteArrayOutputStream os = new ByteArrayOutputStream ();
multiPartResponse.writeTo (os);
final ByteArrayInputStream is = new ByteArrayInputStream (os.toByteArray ());
when(request.getInputStream()).thenReturn(new ServletInputStream() {
        @Override
        public int read() throws IOException {
            return is.read();
        }
    });