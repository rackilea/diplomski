// this code has not been tested
class ABFilter extends FilterInputStream {
    public ABFilter (InputStream in) {
        super(in);
    }
    @Override
    public int read() {
        int character = super.read();
        if (character == 97)
            return 98;
        return character;
    }
    // similarly implement all other "read()" methods
}