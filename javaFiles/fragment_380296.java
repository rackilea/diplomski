@Constraint(validatedBy = CommonsEmailValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface CommonsEmail {
String message() default "{org.hibernate.validator.constraints.Email.message}";

Class<?>[] groups() default {};

Class<? extends Payload>[] payload() default {};

/**
 * Defines several {@code @Email} annotations on the same element.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface List {
    CommonsEmail[] value();
}

public static class CommonsEmailValidator implements ConstraintValidator<CommonsEmail, CharSequence> {

    @Override
    public void initialize(CommonsEmail annotation) {
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return EmailValidator.getInstance(false).isValid(value.toString());
    }

  }
}