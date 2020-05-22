public class G {
    static class A<T extends B> {
        A(T objectT, D objectD, E objectE, F objectF) { }
    }

    static class B { }

    static class C<XT extends B, T extends A<XT>> {
        private Constructor<?> classAConstructor;
        public C(Class<T> classA, Class<XT> classX) throws SecurityException, 
            NoSuchMethodException {
            classAConstructor = classA.getConstructor(classX, D.class,
                    E.class, F.class);
        }
    }
    static class D { }
    static class E { }
    static class F { }

    static class X extends B { }

    public static class H extends A<X> {
        public H(X objectT, D objectD, E objectE, F objectF) {
            super(objectT, objectD, objectE, objectF);
        }
    }

    public static void main(String[] args) throws SecurityException,
        NoSuchMethodException {
        new C<X, H>(H.class, X.class);
    }
}