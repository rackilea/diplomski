public static void setNewErrorMessage(String newErrorMessage, ConstraintValidatorContext context) {

    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate(newErrorMessage)
            .addConstraintViolation();
}