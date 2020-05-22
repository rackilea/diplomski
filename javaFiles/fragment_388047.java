public class MatchesValidator implements ConstraintValidator<Matches, String> {

    private String comparison;

    @Override
    public void initialize(Matches constraint) {
        this.comparison = constraint.value();
    }

    @Override
    public boolean isValid(
        String value,
        ConstraintValidatorContext constraintValidatorContext) {

        return value == null || comparison.equals(value);
    }
}