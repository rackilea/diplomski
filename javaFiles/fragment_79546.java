static class A {

}

public static void main (String[] args) {
    String test1 = "";
    A test2 = new A();
    int test3 = 3;

    System.out.println(isJavaLang(test1));
    System.out.println(isJavaLang(test2));
    System.out.println(isJavaLang(test3));
}

public static boolean isJavaLang(Object check) {
    return check.getClass().getName().startsWith("java.lang");
}