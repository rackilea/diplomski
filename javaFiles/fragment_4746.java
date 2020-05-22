@RequestMapping(value = { "/validate" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
@ResponseBody
public String validate(Model model, @RequestBody @Valid MyAccount myAccount, BindingResult bindingResult, Locale locale) throws JsonProcessingException {

    System.out.println("myAccount user id = " + myAccount.getUserId());

    String msg = "";
    List<ObjectError> errors = bindingResult.getAllErrors();
    for (ObjectError error : errors ) {
        msg = msg + (messageSource.getMessage(error, locale)) + "\n";
    }                       

    return msg;
}