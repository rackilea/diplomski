public static void main(String[] args) {
    try {
        processA(12);
    } catch (ArithmeticException | NullPointerException | IllegalStateException e) {
        // do something here
    } 
}