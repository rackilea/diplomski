public static void main(String[] argv) {
    Fraction f1 = new Fraction();
    f1.inputValues();

    while (f1.isZero()) {
        f1.inputValues();
    }

}