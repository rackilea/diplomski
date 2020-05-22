public class Base {
    protected Logger logger = Logger.getLogger(Base.class);

    protected final void foo() {
        logger.debug("foo");
    }
}

class DerivedA extends Base {
    {
        logger = Logger.getLogger(DerivedA.class);
    }

    public void boo() { foo(); }
}

class DerivedB extends Base {
    {
        logger = Logger.getLogger(DerivedB.class);
    }
    public void boo() { foo(); }
}