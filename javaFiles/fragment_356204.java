public class FooBarView /* Not a FooDTO */ {
    private final FooDTO dto;

    //...

    // Maps field to JSON as 'fooBarColor'
    @JsonMap("fooBarColor")
    public String getColor() {
       return dto.getColor();
    }
}