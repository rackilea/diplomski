final Errors errors = new MapBindingResult(responseMap, "responseMap");
myValidator.validate(responseMap, errors);
if (errors.hasErrors())
{
    throw new MyWebserviceValidationException(errors);
}