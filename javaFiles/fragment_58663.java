@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Foo
{
    @Nonbinding
    ... // you could add parameters for your annotation, e.g. @Foo(value)
}