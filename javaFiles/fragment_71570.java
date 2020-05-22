public enum SearchType implements Typed {
    BARCODE(0),
    TEXT(1);

    private final int type;

    private SearchType(int type) {
        this.type = type;
    }

    @Override
    public int getNumericType() {
        return this.type;
    }

    public static SearchType getType(int type) {
        return Typed.getType(values(), type);
    }
}