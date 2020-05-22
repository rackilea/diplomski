class SomeClass {
    private RandomAccessFile raf = null;

    public SomeClass(String theName) throws IOException {
        this(new RandomAccessFile(theName, "r"));
    }

    public SomeClass(RandomAccessFile raf) {
        this.raf = raf;
    }
}