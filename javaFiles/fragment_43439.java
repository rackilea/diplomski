package com.example.dcsohl;

import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;

public class TestTest {

    public static class A {
        protected String a;
        protected String b;

        public A(String b1) {
            this("A111", b1);
        }

        public A(String a1, String b1) {
            a = a1;
            b = b1;
        }
    }

    public static class B extends A {
        public B(String b1) {
            super("A", b1);
        }

        public String getA() {
            return this.a;
        }

        public String getB(){
            return this.b;
        }
    }

    @Test
    public void test() {
        new MockUp<A>() {
            @Mock public void $init(Invocation inv, String a1, String b1) {
                A a = inv.getInvokedInstance();
                Deencapsulation.setField(a, "b", b1);
            }
        };

        B b = new B("foo");

        System.out.println(b.getA());
        System.out.println(b.getB());

    }

}