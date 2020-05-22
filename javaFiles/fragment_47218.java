@RequestMapping(value="/",method=RequestMethod.GET)
public ModelAndView sayHello(Model model){
    model.addAttribute("message", "Welcome from spring - mvc");
    return new ModelAndView("welcome");
}
@RequestMapping(value="/helloAgain",method=RequestMethod.GET)
public ModelAndView sayHelloAgain(Model model){
    model.addAttribute("message", "Welcome again from spring - mvc");
    return new ModelAndView("welcome");
}