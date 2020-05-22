@Override
public int read() throws IOException {
    int c = super.read();
    if (c == -1) return c;

    char ch = (char) c;
    return Character.toUpperCase(ch);
}