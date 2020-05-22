interface Q {
    void fun();
}
class ABC {
    public static boolean x = false;  // class variable
    public static void b(Q q) {
        q.fun();
    }

    public static void main(String[] args) {
        Q a = () -> {
            System.out.println("run simple lambda");
            x = true;
        };
        b(a);
        System.out.println(x);
    }
}