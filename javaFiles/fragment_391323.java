@RequestMapping(value="/loggedin",method=RequestMethod.POST)
public ModelAndView login(HttpServletRequest request,
             @ModelAttribute("PersonAttribute") Person person,
             HttpSession session) {

    ModelAndView modelAndView = new ModelAndView("success");
    modelAndView.addObject("person", person);
    person=personDAO.select(person);
    System.out.println(person.getStory());
     session=request.getSession(true);
    session.setAttribute("person",person);
    modelAndView.setViewName("success");

    return modelAndView;
}