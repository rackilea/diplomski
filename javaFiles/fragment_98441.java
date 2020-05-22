public class UuidValidator implements ConstraintValidator<ValidUuid, UUID> {
    private final String regex = "....." // the regex

    @Override
    public void initialize(ValidUuid validUuid) { }

    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext cxt) {
        return uuid.toString().matches(this.regex);
    }
}