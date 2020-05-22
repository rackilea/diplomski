public static void main(String args[]) {
    System.out.print("Word:");
    Scanner scanner = new Scanner(System.in);
    String foo = scanner.next();
    foo = foo.replace("a", "aaa");
    System.out.println(foo);
    foo = foo.replace("d", "");
    System.out.println(foo);
    foo = foo.replace("bb", "b");
    System.out.println(foo);
}