@NameBinding
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {}

methodBuilder
    .nameBinding(Authorization.class)
    .produces(MediaType.TEXT_PLAIN)
    .handledBy(new TestInflector());

@Authorization
public class AuthorizationFilter implements ContainerRequestFilter {}