public enum EXIT_CODE {
    A(104), B(203);

    private int numVal;

    EXIT_CODE(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}