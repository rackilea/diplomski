public static void bar(int... a) {
    System.out.println("Varargs");
}

public static void bar(Object a) {
    System.out.println("Object");
}

public static void main(String[] args) {
    bar(new int[] {1, 2, 3});    // Prints Varargs
}