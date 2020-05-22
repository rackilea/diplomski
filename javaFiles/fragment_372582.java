@Documented
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
public @interface TypeOne {

}

@Documented
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
public @interface TypeTwo {

}


@TypeOne
@Stateless
public class MyBean implements MyBeanLocal

@TypeTwo
@Stateless
public class MyBean implements MyBeanLocal