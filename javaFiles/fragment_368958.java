class Class {

    public static void foo(int a, int b, int c) {
        boolean val = (a == c && b != c) ? true : false;
        System.out.println(val);
    }

    public static void main(String[] args) {
       foo(1,2,3);
    }
}