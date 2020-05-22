@RequestMapping(method = RequestMethod.POST)
public ModelAndView processRegistration(@ModelAttribute("userForm") User user, Map<String, Object> model)
{       
    model.addAttribute("username", user.getUserName());
    model.addAttribute("password", user.getPassword());
    model.addAttribute("birthDate", user.getBirthDate());
    model.addAttribute("email", user.getEmail());
    model.addAttribute("profession", user.getProfession());
    model.addAttribute("userForm", new User());                 
    return new ModelAndView("RegisterSuccess",model);
}