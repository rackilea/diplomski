class Wrapper1 implements MyInterface {

    private final Type1 type1;

    Wrapper1(Type1 type1) {
        this.type1 = type1;
    }

    @Override
    public void myMethod() {
        type1.method1();
    }
}