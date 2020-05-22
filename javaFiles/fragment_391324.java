@RequestMapping(value="/loggedin",method=RequestMethod.POST)
public ModelAndView login(HttpServletRequest request,
             @ModelAttribute("PersonAttribute") Person person,
             HttpSession session) {

    Person loadedPerson=personDAO.select(person);

    ModelAndView modelAndView = new ModelAndView("success");
    modelAndView.addObject("person", loadedPerson);
    //System.out.println(person.getStory());       
    request.getSession(true).setAttribute("person", loadedPerson);

    return modelAndView;
}