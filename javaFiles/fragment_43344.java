public static void main(String[] args) {
    int x = 0;
    foo(x);
    System.out.println(x);
}
public static void foo(int x) {
    x = 4;
}