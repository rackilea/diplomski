class Test {
    private Test() {
        System.out.println("test");
    }
    public static Test getInstance(){
        return new Test();
    }
    public void methodA(){
        //Some kind of implementation
    }
}

public class One {
    private final Test test;
    One() {
        System.out.println("One");
        test = Test.getInstance();
    }

    public void methodA(){
        test.methodA();
    }

    public static void main(String args[]) {
        new One();
    }
}