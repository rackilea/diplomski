public enum Numbers {
    N2(2), N3(3), N4(4), N5(5), N6(6), N7(7), N8(8), N9(9), 
            N10(10), JACK(11), KING(12), QUEEN(13), ACE(1);
    Numbers(int value) {
        this.value = value;
    }

    private int value;

    public String toString() {
        return Integer.toString(value);
    }
}