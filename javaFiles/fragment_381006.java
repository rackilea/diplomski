public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserRequest> {
    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserRequest value, ConstraintValidatorContext context) {
        // call to the DB and verify that value.getEmail() is unique
        return false;
    }
}