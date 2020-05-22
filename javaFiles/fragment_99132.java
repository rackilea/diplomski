public class A implements Serializable {
    //  since the first bound is Cloneable, the erasure is Cloneable
    static <T extends Cloneable & Serializable> void doSomething1(T t) {}

    //  since the first bound is Serializable, the erasure is Serializable
    static <T extends Serializable & Cloneable> void doSomething2(T t) {}

    // since T is not bounded, the erasure is Object
    static <T> void doSomething(T t) {
        System.out.println("A");
    }

    // the type of A is a class, so it has to come first
    // the erasure is A since it comes first
    static <T extends A & Serializable> void doSomething(T t) {
        System.out.println("B");
    }

    // not possible because the bounds are two classes
    // static <T extends Object & A> void doSomething(T t) {return null;}
}