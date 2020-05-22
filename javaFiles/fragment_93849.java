static private int value;

static {
    abstract class Abstract {
        abstract int method1();
    }
    class Child1 extends Abstract {
        int method1() {
            return 1;
        }
    }
    class Child2 extends Abstract {
        int method1() {
            return 2;
        }
    }
    Abstract instance1 = new Child1();
    Abstract instance2 = new Child2();
    value = instance1.method1() + instance2.method1();
}