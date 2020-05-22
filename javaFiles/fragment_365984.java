public class MyValidationAdapter extends SpringValidatorAdapter{
public MyValidationAdapter(Validator targetValidator) {
    super(targetValidator);
}
@Override
public Object[] getArgumentsForConstraint(String objectName,
        String field, ConstraintDescriptor<?> descriptor) {
    return super.getArgumentsForConstraint(objectName, field, descriptor);
}
@Override
public void processConstraintViolations(
        Set<ConstraintViolation<Object>> violations, Errors errors) {
    super.processConstraintViolations(violations, errors);
}
}