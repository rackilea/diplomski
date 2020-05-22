public static void main(String[] args) {
    method(1);      // <- compile error
    method(1,2);
    method(1,2,3);
    method(1,2,3,4);
}

private static void method(int i1, int i2, int...i3) {
    // do something
}