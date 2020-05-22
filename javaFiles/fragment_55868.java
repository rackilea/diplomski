public interface EmptyChecks {}

@GroupSequence( { EmptyChecks.class, Foo.class } )
public class Foo {
    @Length(min = 6, max = 30, groups=EmptyChecks.class)
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*)", message = "{error.password.too_simple}")
    private String password;

    //...
}