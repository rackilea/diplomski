static void closeAfterInputStreamIsConsumed(InputStream is)
        throws IOException {
    int r;

    while ((r = is.read()) != -1) {
        System.out.println(r);
    }

    is.close();
    System.out.println("=========");

}

public static void main(String[] args) throws IOException {
    InputStream is = new ByteArrayInputStream("sample".getBytes());
    ResetOnCloseInputStream decoratedIs = new ResetOnCloseInputStream(is);
    closeAfterInputStreamIsConsumed(decoratedIs);
    closeAfterInputStreamIsConsumed(decoratedIs);
    closeAfterInputStreamIsConsumed(is);
}