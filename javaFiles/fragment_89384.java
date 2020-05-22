@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonString {
    String message() default "The String is not in JSON format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}