@WebMethod
public string[] myMethod() throws FooException {
    // do some stuff
    throw new FooException();
    // or with a cause
    try { 
        // something dangerous
    } catch (Exception e) {
        throw new FooException("Shit happens", new FooFault(), e);
    }
    // or like this
    throw new FooException("Foo", new FooFault());
}