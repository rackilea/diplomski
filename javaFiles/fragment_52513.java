@Autowired
private MyValidator myValidator;

@RequestMapping(value = "save", method = RequestMethod.POST)
public String save(@ModelAttribute("myBean") MyBean myBean, BindingResult result) {

    myValidator.validate(myBean, result);
    if (result.hasErrors()) {
        ...
    }

    ...

}