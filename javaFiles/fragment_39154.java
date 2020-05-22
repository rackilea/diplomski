@Override
public boolean isValid(MyEntity myEntity, ConstraintValidatorContext context) {
    // Disable default ConstraintViolation so a customised message can be set instead.
    context.disableDefaultConstraintViolation();

    return checkConstraint1(myEntity, context)
           && checkConstraint2(myEntity, context)
           //...
           && checkConstraintn(myEntity, context);
}

// Note: A private method for each constraint decreases the cyclomatic complexity.
private boolean checkConstraint1(MyEntity myEntity, ConstraintValidatorContext context) {
    // Default validity is true until proven otherwise.
    boolean valid = true;

    if (/*<<Insert constraint #1 conditions (about myEntity) here>>*/) {
        valid = false;
        context.buildConstraintViolationWithTemplate(
           "<<Insert constraint #1 failure message here>>").addConstraintViolation();
    }

    return valid;
}