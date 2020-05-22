public class Test{
    public static void main(String[] args){
        print();// static method call
        Test test = new Test();
        test.print();// non static method call
    }
    public void print() {
        System.out.println("Hello non static");
    }
    public static void print() {
        System.out.println("Hello static");
    }
}