@ModelAttribute("myclass")
public MyClass myClass() {
    return new MyClass();
}

@InitBinder("myclass")
protected void initBinder(WebDataBinder binder) {
    binder.setValidator(new MyValidator());
}

@RequestMapping(value = "/do/something", method = POST)
public ModelAndView validatedRequest(@Valid @ModelAttribute("myclass") MyClass profile,
                                     BindingResult result) {
    if (result.hasErrors()) {
        // oh noes!
    }
}