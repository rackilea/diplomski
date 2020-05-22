public class OutputEscapingStreamWriter extends OutputStreamWriter {

    public OutputEscapingStreamWriter(OutputStream out, Charset cs) {
        super(out, cs);
    }

    public OutputEscapingStreamWriter(OutputStream out) {
        super(out);
    }

    public OutputEscapingStreamWriter(OutputStream out, String cs) throws UnsupportedEncodingException {
        super(out, cs);
    }

    public OutputEscapingStreamWriter(OutputStream out, CharsetEncoder cs) {
        super(out, cs);
    }

    private static String HEX_DIGITS = "0123456789abcdef";

    @Override
    public void write(int c) throws IOException {
        if (c < 128) {
            super.write(c);
        }
        else {
            super.write(toHexString(c));
        }
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        for (int i = off; i < (off + len); i++) {
            write(str.charAt(i));
        }
    }

    @Override
    public void write(char cbuf[], int off, int len) throws IOException {
        for (int i = off; i < (off + len); i++) {
            write(cbuf[i]);
        }
    }

    private String toHexString(int c) {
        StringBuilder sb = new StringBuilder("\\u");
        sb.append(HEX_DIGITS.charAt((c & 0xF000) >> 12));
        sb.append(HEX_DIGITS.charAt((c & 0x0F00) >> 8));
        sb.append(HEX_DIGITS.charAt((c & 0x00F0) >> 4));
        sb.append(HEX_DIGITS.charAt((c & 0x000F) ));
        return sb.toString();
    }
}