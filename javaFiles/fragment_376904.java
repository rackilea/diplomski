@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=AtLeastOneNotNullValidator.class)

public @interface AtLeastOneNotNull{
 String message() default "Your error message";
 Class<!--?-->[] groups() default {};
 Class<!--? extends Payload-->[] payload() default {};
}