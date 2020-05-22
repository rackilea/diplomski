class A {
    int x;
    int y;
    public static void main(String args[]) {
        A a = new A();

        System.out.println(a.x);
        a.y = 3;

        if (a.y == a.x) {
            // ...
        }
        else if (a.y == something_else) {
            // ...
        }
        else {
            // ...
        }
    }
}