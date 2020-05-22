private class StatePrintWriter extends PrintWriter {

    public StatePrintWriter(PrintWriter writer) {
        super(writer);
    }


    public boolean isOpen() {
        return out != null;
    }
}