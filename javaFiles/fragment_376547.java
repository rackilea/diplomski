static private abstract class Base {
    public void test() {
        System.out.println("Base");
    } 
}

static private class A extends Base {
    private void test() {
        System.out.println("A");
    }
}

static private class B implements Base {
    private void test() {
        System.out.println("B");
    }
}

static private class C extends B {
    private void test() {
        System.out.println("C");
    }
}