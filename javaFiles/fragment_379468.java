public abstract class Base {
    protected abstract Logger getLogger();

    protected final void foo() {
        getLogger().debug("foo");
    }
}

class DerivedA extends Base {
    private static final Logger logger = Logger.getLogger(DerivedA.class);

    public void boo() { foo(); }

    protected Logger getLogger() { return logger; }
}

class DerivedB extends Base {
    private static Logger logger =  Logger.getLogger(DerivedB.class);

    public void boo() { foo();}

    protected Logger getLogger() { return logger; }
}