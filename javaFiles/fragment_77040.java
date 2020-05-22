public class A {
    @Autowired B b;

    @Transactional
    public void foo() {
        try {
            b.bar();
        }
        catch (RuntimeException e) {
            // ignore
        }

        ...
    }
}

public class B {
    // @Transactional(propagation = Propagation.SUPPORTS)
    public void bar() {
        throw new RuntimeException();
    }
}