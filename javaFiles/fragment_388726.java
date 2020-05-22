@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidIntegerValidator.class)
public @interface ValidInteger {
    String message() default "not a valid integer!";
    int min() default 1;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

public class ValidIntegerValidator implements ConstraintValidator<ValidInteger, Object> {
    @Override
    public void initialize(ValidInteger constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Integer.parseInt((String) value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}