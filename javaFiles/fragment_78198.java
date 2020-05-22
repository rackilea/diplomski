@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = DoubleMinValidator.class)
@play.data.Form.Display(name="constraint.min", attributes={"value"})
public @interface DoubleMin {
    String message() default DoubleMinValidator.message;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    double value();
}


public class DoubleMinValidator extends Validator<Number> implements ConstraintValidator<DoubleMin, Number> {

    final static public String message = "error.min";
    private double min;

    public DoubleMinValidator() {}

    public DoubleMinValidator(double value) {
        this.min = value;
    }

    public void initialize(DoubleMin constraintAnnotation) {
        this.min = constraintAnnotation.value();
    }

    public boolean isValid(Number object) {
        if(object == null) {
            return true;
        }

        return object.doubleValue() >= min;
    }

    public Tuple<String, Object[]> getErrorMessageKey() {
        return Tuple(message, new Object[] { min });
    }

}