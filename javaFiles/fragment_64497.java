@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Supports {

    String value();
}