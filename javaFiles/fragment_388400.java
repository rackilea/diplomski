public class Main {

    public static void main(String[] args) {
         new MyClass().doSomething();
    }

}


class MyClass{
    Object obj ;

    public void doSomething(){
        createObject();
    }


    private void createObject(){
        obj = new Object();
        System.out.println("Created MyClass instance");
    }
}