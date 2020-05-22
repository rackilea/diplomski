public class Test {

    public static void printNumber(int number) {
        number = 100;//Copy of actual variable number of main method
    }

    public static void main(String[] args) {
        int number = 25;
        printNumber(number);
        System.out.println(number);//Still print 25
    }

}