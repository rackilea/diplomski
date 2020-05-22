@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Value("")
public @interface Refreshable {

    @AliasFor(annotation=Value.class, attribute="value")
    String value();
}