public enum ResultcodeType implements Typed {
    RESULTS(0),
    NO_RESULTS(1),
    PROBLEMS(2),
    NO_VALUE(-1);

    private final int type;

    private ResultcodeType(int type) {
        this.type = type;
    }

    @Override
    public int getNumericType() {
        return this.type;
    }

    public static ResultcodeType getType(int type) {
        return Typed.getType(values(), type);
    }
}