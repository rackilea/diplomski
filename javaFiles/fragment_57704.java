public class UsernameValidator implements ConstraintValidator<Username, String>
{
    private boolean isUpdate;

    public void initialize(Username constraintAnnotation)
    {
        isUpdate = constraintAnnotation.isUpdate();
    }

    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        if (isUpdate)
        {
            // Make sure the user exists
        }
        else
        {
            // Make sure the user doesn't exist
        }           
    }
}