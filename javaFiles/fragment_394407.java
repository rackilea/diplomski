@Inject
private SubmitModelValidator customValidator;

public String handleRequest(@PathVariable("devicename") String devicename, @Valid @ModelAttribute SubmitModel model, BindingResult errors) throws UCLoginException { ... }
    customValidator.validate(model, errors);
    if (errors.hasErrors()) {
        ...
    }
    ...
}