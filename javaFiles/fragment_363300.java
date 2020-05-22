// src/foo/A.java
package foo;
import bar.*;

public class A {
    public static void main(String[] args) {
        B.sayHello();
    }
}

// src/bar/B.java
package bar;
public class B {
    public static void sayHello() {
        System.out.println("Hello");
    }
}