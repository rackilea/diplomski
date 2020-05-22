public class CustomOutputStream extends ServletOutputStream {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String content;

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void close() throws IOException {
        content = new String(out.toByteArray());
        out.close();
        super.close();
    }

    public String getContentAsString() {
        return this.content; 
    }
}