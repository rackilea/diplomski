public class Test {


    private static int m;// this is a static variable

    private int n;// this is an instance variable

    public static void main(String[] args) throws Exception {

        printM();//no need for any instance as printM() is static


//      since 'n' is an instance variable it cannot be used without an instance inside a static method
//      creating instance
        Test test = new Test();
        test.printN();//instance is need to call printN()
    }

    private static void printM() {
        m = 25;
        System.out.println("hi from static method 'm' is: " + m);
    }

    private void printN() {
        n = 15;
        System.out.println("hi from instance method 'n' is: " + n);
    }
}