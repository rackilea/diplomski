private static class Test3 {
    int i = 1;
}

private static class Test4 extends Test3 {
    int i = 2;
}

public static void main(String[] args) {
    Test4 t4 = new Test4();
    System.out.println(t4.i);

    System.out.println("======");

    Test3 t34 = new Test4();
    System.out.println(t34.i);
}