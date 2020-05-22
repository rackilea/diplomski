public class IpAddressValidator implements ConstraintValidator<IpAddress, Object>
{
  @Override
  public void initialize(IpAddress constraintAnnotation)
  {
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext cvContext)
  {
    // logic here
  }
}