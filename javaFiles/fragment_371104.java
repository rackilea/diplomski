Object value = input.getSubmittedValue();
try {
    value = input.getConvertedValue(facesContext, value);
} catch (ConverterException e) {
    // ...
    return;
}
try {
    for (Validator validator : input.getValidators())
        validator.validate(facesContext, input, value);
    }
    input.setSubmittedValue(null);
    input.setValue(value); // You see?
} catch (ValidatorException e) {
    // ...
}