@RequestMapping(value="/do_register", method= RequestMethod.GET)
public ModelAndView RegistrationForm(@ModelAttribute Subscriber subscriber, BindingResult result)
{

    ...
    // I want to pass both "myCities" and "interest" to my view File
    ModelAndView mav =  ModelAndView("regForm");
    mav.addAttribute("interests", interest);
    mav.addAttribute("records", myCities);
    return mav;
}