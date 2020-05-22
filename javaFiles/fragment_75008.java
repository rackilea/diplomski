public abstract class TestFor<T> {

    protected Class<T> _class = null;
    public Map<Class, Object> _mocks = new HashMap<>();
    protected T Target = null;

    protected TestFor(Class<T> cls) {
        _class = cls;

        List<Constructor> allConstructors = Arrays.asList(_class.getDeclaredConstructors());
        Constructor ctorWithLongestParameter = Collections.max(allConstructors,
            (o1, o2) -> Integer.compare(o1.getParameterCount(), o2.getParameterCount()));

        List<Object> objects = new ArrayList<>();
        int i = 0;
        for (Class<?> type : ctorWithLongestParameter.getParameterTypes()) {
            Object mock = _mocks.get(type);
            if (mock == null) {
                mock = Mockito.mock(type);
                _mocks.put(type, mock);
            }
            objects.add(mock);
        }
        try {
            Target = _class.cast(ctorWithLongestParameter.newInstance(objects.toArray(new Object[objects.size()])));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public <E> E the(Class<E> cls) {
        return cls.cast(_mocks.get(cls));
    }

    public static void main(String[] args) {
        TestFor<A> test = new TestFor<A>(A.class) {};
        System.out.println(test.Target);
        System.out.println(test.the(Object.class));
        System.out.println(test.the(Number.class));
    }

    public static class A {
        public A() {
            System.out.println("Empty constructor");
        }
        public A(Object o) {
            System.out.println("Constructor [o=" + o + ']');
        }
        public A(Object o, Number n) {
            System.out.println("Constructor [o=" + o + ", n=" + n + ']');
        }
    }
}