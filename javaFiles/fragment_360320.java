public static void scopeOne() {
    String myName = "name";
    scopeTwo(myName);
}

public static void scopeTwo(String myName) {
    System.out.println(myName);
}