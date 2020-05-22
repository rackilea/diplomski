class IntParser implements DataParser {
    public void parse(DataInputStream in, PrintStream out) {
        int value = in.readInt();
        out.print(value);
    }
}