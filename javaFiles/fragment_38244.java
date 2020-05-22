@Validated
public interface MyClassWithMethodsToValidate {

    @ValidateReturnValue({FooResponseGroup.class})
    @ValidateArguments({FooRequestGroup.class})
    FooResource createFoo(Foo foo);
}