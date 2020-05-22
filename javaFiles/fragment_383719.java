static class MyWrapper extends PushbackInputStream {
    MyWrapper(InputStream in) {
        super(in);
    }

    @Override
    public int available() throws IOException {
        int b = super.read();
        // do something specific?
        super.unread(b);
        return super.available();
    }
}

public static void main(String... args) {
    InputStream originalSocketStream = null;
    DataInputStream dis = new DataInputStream(new MyWrapper(originalSocketStream));
}