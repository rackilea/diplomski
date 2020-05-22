public static void main(String[] args) {
    try {
        NitPickyMath.remainder(1, 0);
    } catch (DivideByZeroException e) {
        e.printStackTrace();
    }
}