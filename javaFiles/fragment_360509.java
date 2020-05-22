try {
    int a = 5;
    int b = 0;
    int c = a/b; // Division by 0, throws an ArithmeticException
}
catch (ArithmeticException e) {
    e.printStackTrace();
}