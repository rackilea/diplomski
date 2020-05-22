@Min(0)
@Max(86399)
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface DaySeconds {

    String message() default "{your.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}