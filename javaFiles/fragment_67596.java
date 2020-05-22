public class ValidatePostalCodeImpl implements ConstraintValidator<ValidatePostalCode, Integer> {

    int upperValue;
    int lowerValue;

    @Override
    public void initialize(ValidatePostalCode validate) {
        this.upperValue = validate.maxValue(); // here you call them as if they indeed were regular methods
        this.lowerValue = validate.minValue();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext context) {
        return integer >= lowerValue && integer <= upperValue;
    }

}