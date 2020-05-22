abstract class MyWrapper {

    static MyWrapper of(Type1 type1) {
        return new Wrapper1(type1);
    }

    static MyWrapper of(Type2 type2) {
        return new Wrapper2(type2);
    }

    abstract void myMethod();
}