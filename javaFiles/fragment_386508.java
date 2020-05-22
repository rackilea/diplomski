package com.matt.tester;

public class SE {

    static class A {
        B b;

        A() {
            instantiateB();
        }

        void instantiateB () {
            this.b = new B();
        }

        void foo() {
            b.foo();
        }

        /* More A-class methods here */
    }

    static class B {
        void foo() {
            System.out.println("Hellow from B.foo()!");
        }

        /* More B-class methods here */
    }
    static class ASub extends A {

        @Override
        void instantiateB() {
            this.b = new BSub();
        }
    }
    static class BSub extends B {
         @Override
         void foo() {
            System.out.println("Hellow from BSub.foo()!");
         }
    }

    public static void main(String[] args) {
        A a = new ASub();
        a.foo();
    }
}