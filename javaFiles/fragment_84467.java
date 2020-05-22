@JsonTypeInfo(
        use = JsonTypeInfo.Id.Name, 
      // this will ignore boolean bar value in the parent
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "bar",
      // this will make a default implementation
        defaultImpl = Foo.class)
    @JsonSubTypes( {@Type(value = Bar.class, name = "true") })
    public class Foo{ String value; }

    public class Bar extends Foo { boolean bar; }