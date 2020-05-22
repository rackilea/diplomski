public static void main(String[] args) {
    int a =0;
    int b = 2;
    int c = 10;
    int d = 0;
    int e = 0;

    try {
        d=c/b;
        e=b/a;
    }catch (ArithmeticException ex){
        System.out.println("TEST");
        ex.printStackTrace(System.out);
    }

    System.out.println(d);
}