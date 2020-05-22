@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface TaskAnnotation {
    public String value();
}