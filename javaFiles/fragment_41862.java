@Constraint(validatedBy = NobleValidator.class)
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface Noble {
    String message() default "{NOT_NOBLE}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}