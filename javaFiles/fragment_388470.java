@Root(name = "rs")
public class FooWrapper
{
    @Element(name = "r", required = true)
    private Foo f;


    public FooWrapper(Foo f) // Required just in case you want to serialize this object
    {
        this.f = f;
    }

    FooWrapper() { } // At least a default ctor is required for deserialization
}