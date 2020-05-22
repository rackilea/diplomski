public class Base {

    /** one or more public constructors */
    public Base() { ... }

    /** copy-constructor */
    protected Base(Base src) { /* copy or deep-copy the state */ }

    public Base copy() { return new Base(this); }
}

public class Derived extends Base {

    /** one or more public constructors */
    public Derived() { ... }

    /** copy-constructor */
    protected Derived(Derived src) { 
        super(src);
        /* copy or deep-copy the state */ 
    }

    @Override
    public Derived copy() { return new Derived(this); }
}