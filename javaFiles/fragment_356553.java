public static void main(String[] args) {
    bla();
}

private static void bla(long... x) {}
private static void bla(int... x) {}
private static void bla(short... x) {}
private static void bla(byte... x) {}   // <-- calls this one