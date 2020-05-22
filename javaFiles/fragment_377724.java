@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, METHOD })
public @interface CaseContext {
    public String value() default "";
}