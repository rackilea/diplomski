public abstract class GenericEnumUppercaseConverter<E extends Enum<E>> implements AttributeConverter<E, String> {
    ...
}

public FooConverter
    extends GenericEnumUppercaseConverter<Foo> 
    implements AttributeConverter<Foo, String> // See Bug HHH-8854
{
    public FooConverter() {
        super(Foo.class);
    }
}