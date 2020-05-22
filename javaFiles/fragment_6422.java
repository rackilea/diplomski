public class Base {
    protected interface Factory {
        Base getInstance(Element e);
    }

    private static Map<Class<?>, Factory> registry = new HashMap<Class<?>, Factory>();
    protected static void register(Class<?> c, Factory f) { registry.put(c, f); }
    protected static <T extends Base> T create(Class<T> c, Element e) {
        return (T) registry.get(c).getInstance(e);
    }
}

public class Derived1 extends Base {
    protected Derived1(Element e) { }
    private static class Derived1Factory implements Factory {
        public Derived1 getInstance(Element e) {
            return new Derived1(e);
        }
    }

    static {
        register(Derived1.class, new Derived1Factory());
    }
}

public class Derived2 extends Base {
    protected Derived2(Element e) { }
    private static class Derived2Factory implements Factory {
        public Derived2 getInstance(Element e) {
            return new Derived2(e);
        }
    }

    static {
        register(Derived2.class, new Derived2Factory());
    }

    public void method() {
        Element e = null;
        ...
        // Put some element in e
        ...
        // This is what you were trying to do
        Derived1 d1 = create(Derived1.class, e);
    }
}