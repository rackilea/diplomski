public class EntryWrapper
{
    @Element(name = "v")
    private String value;


    public EntryWrapper(String value)
    {
        this.value = value;
    }

    EntryWrapper() { } // Once again, at least one default ctor is required for deserialization

    // ...
}