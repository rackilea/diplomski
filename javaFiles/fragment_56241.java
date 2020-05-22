class CompositeOutputStream implements OutputStream {
    private OutputStream first,second;
    public CompositeOutputStream(OutputStream first, OutputStream second) {
        this.first = first;
        this.second=second;
    }

    public void write(int b) throws IOException {
        first.write(b);
        second.write(b);
    }

    // etc.
}