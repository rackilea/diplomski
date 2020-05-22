// A.java
package a;
public class A {
    protected int a;
}

// B.java 
package b;   //<-- intermediate subclass
import a.A;
public class B extends A {
}

// C.java
package c; //<-- different package 
import b.B;
public class C extends B  { // <-- C is an indirect sub class of A 
    void testIt(){
        a++;
        System.out.println( this.a );//<-- Inherited from class A
    }
    public static void main( String [] args ) {
        C c = new C();
        c.testIt();
    }
}