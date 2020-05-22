public static void main(String[] args) {
    foo(new Object[] {"1", "2"}); // prints arg = 1\narg=2
    foo((Object) (new Object[] {"1", "2"})); // prints args = [Ljava.lang.Object;@969cccc
}

private static void foo(Object... args) {
    for (Object arg : args) {
        System.out.println("arg = " + arg);
    }
}