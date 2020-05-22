public class Parent{
    public static class Child{
        public void aMethod(String s){
            System.out.println("Hi!" + s);
        }
    }
}

public class AnotherClass{
    public void AnotherMethod(){
        Parent.Child.aMethod("From AnotherClass");
    }
}