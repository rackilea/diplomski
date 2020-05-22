class ConsumerManagementCommandValidator extends net.sf.oval.Validator{

@Override
protected void checkConstraintAssertValid(
        List<ConstraintViolation> violations, AssertValidCheck check,
        Object validatedObject, Object valueToValidate,
        OValContext context, String[] profiles) throws OValException {

    if (valueToValidate == null) return;

    // ignore circular dependencies
    if (isCurrentlyValidated(valueToValidate)) return;

    // changed here access to private class variable to getter
    final List<ConstraintViolation> additionalViolations = getCollectionFactory().createList();
    validateInvariants(valueToValidate, additionalViolations, profiles);

    if (additionalViolations.size() != 0) {
        final String errorMessage = renderMessage(context, valueToValidate, check.getMessage(), check.getMessageVariables());

        violations.add(new ConstraintViolation(check, errorMessage, validatedObject, valueToValidate, context, additionalViolations));
        //add the violations to parent list :-)
        violations.addAll(additionalViolations);
    }
}

@Override
public List<ConstraintViolation> validate(Object validatedObject, String... profiles) throws IllegalArgumentException, ValidationFailedException {
    // TODO Auto-generated method stub
    return super.validate(validatedObject, profiles);
}