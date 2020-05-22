public class ClassTest {

    class A{

    }

    class B extends A{

    }


    public static void main(String[] args) {
        ClassTest t = new ClassTest();
        A a = t.new B();

        System.out.println(a instanceof B); //true
        System.out.println(a instanceof A); //true

        System.out.println(a.getClass().equals(B.class)); //true
        System.out.println(a.getClass().equals(A.class)); //false
    }

}