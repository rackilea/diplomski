import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YourDateValidator implements ConstraintValidator< ValidDates, 
    TypeToBeValidated> {

    @Override
    public void initialize(ValidDates constraintAnnotation) {
    }

    @Override
    public boolean isValid(TypeToBeValidated value, ConstraintValidatorContext context) 
    {
        < validation code, returning true for a valid value >
    }

}