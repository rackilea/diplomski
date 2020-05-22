class A {
    A() {   <-- accessible only in current package
    }
}

public class B extends A implements Serializable {
    public B() {
    }
}