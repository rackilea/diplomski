public class A {

    private B obj;

    public A() {
        obj = new B(this);
        ...
    }

    public void method1(){    ...    }
    public void method2(){    ...    }
}


public class B {

    private final A _a;

    public B(A a) {
        _a = a;
    }

    public class MouseActionsListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent event) {
            _a.method1();
        }
    }