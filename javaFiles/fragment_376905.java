public class AtLeastOneNotNullValidator implements ConstraintValidator<AtLeastOneNotNull, object=""> {

 @Override
 public void initialize(AtLeastOneNotNull constraint) {

 }

 @Override
 public boolean isValid(Object target, ConstraintValidatorContext context) {
    // Add logic to check if atleast one element have one field
 }
}