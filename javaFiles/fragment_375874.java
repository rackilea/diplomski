@Documented
@Constraint(validatedBy = {})
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@NotEmpty
@ReportAsSingleViolation
public @interface Required {
    public abstract String label();
    public abstract Class<?>[] groups() default {};
    public abstract String message() default "{Required.message}";
    public abstract Class<? extends Payload>[] payload() default {};
}