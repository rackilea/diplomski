public class Test {
    public static int returnValue() {
        return 0;
    }

    public static void main(String[] arg) {
        System.out.println(Test.returnValue());
        System.out.println(Test2.returnValue());
        Test x = new Test2();
        System.out.println(x.returnValue());
    }
}


public class Test2 extends Test {
    public static int returnValue() {
        return 1;
    }
}