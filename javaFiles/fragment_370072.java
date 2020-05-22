public class A {

    public void myMethod() {
        System.out.println("A.myMethod()");
    }

    public void myOtherMethod() {
        System.out.println("A.myOtherMethod()");
        myMethod();
    }

    public static class SubA extends A {

        @Override
        public void myMethod() {
            System.out.println("SubA.myMethod()");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        SubA subA = new SubA();
        a.myMethod(); //A.myMethod()
        subA.myMethod(); //SubA.myMethod()
        a.myOtherMethod(); //A.myOtherMethod() + A.myMethod()
        subA.myOtherMethod(); //A.myOtherMethod() + SubA.myMethod()
    }

}