class Main {

    public static void main(String[] args) {

        test(str ->System.out.println(str), "Hello world!!!");

    }

    public static void test(DoWork d, String str) {
        d.doit(str);
    }

}