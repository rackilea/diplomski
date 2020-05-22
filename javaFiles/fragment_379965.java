public ValidationResult validateInput(Input input) {
    ValidationResult result = new ValidationResult();
    if (input.someField() == null) {
      result.addError("Some field cannot be null");
    }
    //etc
    return result;
 }