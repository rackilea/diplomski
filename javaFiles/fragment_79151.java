public class MoneyValidator implements ConstraintValidator<ValidMoney, Money> {

    @Override
    public void initialize(ValidMoney constraintAnnotation) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isValid(Money value, ConstraintValidatorContext context) {
        return value.isValid();
    }

}