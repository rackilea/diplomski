@WebFault(faultBean = "org.foo.bar.FooFault")
public class FooException extends Exception {
    private FooFault fooFault;

    public FooException() {
        super();
    }

    public FooException(String message, FooFault fooFault, Throwable cause) {
        super(message, cause);
        this.fooFault = fooFault;
    }

    public FooException(String message, FooFault fooFault) {
        super(message);
        this.fooFault = fooFault;
    }

    public FooFault getFaultInfo() {
        return fooFault;
    }
}

// this is org.foo.bar.FooFault
public class FooFault {
    // POJO
}