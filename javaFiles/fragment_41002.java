@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@BindingAnnotation
public @interface Priority
{
    Level value();

    public enum Level
    {
        LOW,
        HIGH
    }
}