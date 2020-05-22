@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueEmailValidator.class })
@Documented
public @interface UniqueEmail {
    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}