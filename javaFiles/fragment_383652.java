public class CallSuper {

    static class Parent {
        public void foo() {
            System.out.println("Parent.foo");
        }

        /** 
         * Calls foo to do the main work
         */
        public void bar() {
            System.out.print
            foo();
        }
    }

    static class Child extends Parent {
        public void foo() {
            System.out.println("Child.foo");
        }

        public void bar() {
            super.foo();
        }
    }

    static class GrandChild extends Child {
        public void foo() {
            System.out.println("GrandChild.foo");
        }
    }

    public static void main(String[] args) {
        Parent p = new Parent();
        Parent c = new Child();
        Parent g = new GrandChild();

        System.out.print("Parent.foo() = ");
        p.foo();
        System.out.print("Child.foo() = ");
        c.foo();
        System.out.print("GrandChild.foo() = ");
        g.foo();

        System.out.print("Parent.bar() = ");
        p.bar();
        System.out.print("Child.bar() = ");
        c.bar();
        System.out.print("GrandChild.bar() = ");
        g.bar();
    }
}