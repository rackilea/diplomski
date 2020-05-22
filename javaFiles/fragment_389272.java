@Autowired
SomethingParamsValidator somethingParamsValidator;

@InitBinder
protected void initBinder(WebDataBinder binder) {
    binder.setValidator(somethingParamsValidator);
}