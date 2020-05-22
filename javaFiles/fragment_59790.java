@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Qualifier
public @interface MyQualifier { ... }

@Service
@MyQualifier
public class FooHandler implements IHandler { ... }

@Component
public class MyClass {
    @Autowired @MyQualifier
    private IHandler handler;

    ...
}