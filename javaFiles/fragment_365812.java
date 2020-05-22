@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidarImpl implements
ConstraintValidator < Validar, Object[] > {

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        if (value.length != 2) {
            throw new IllegalArgumentException("Illegal method signature");
        }

        if (value[0] == null || value[1] == null) {
            return true;
        }

    }
}