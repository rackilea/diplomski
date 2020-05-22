@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoggableActivity {
    String value();

    String args() default "";
}