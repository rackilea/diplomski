@RequestMapping(value = "/admin**", method = RequestMethod.GET)
public ModelAndView adminPage() {

    ModelAndView model = new ModelAndView();
    model.addObject("title", "Spring Security + Hibernate Example");
    model.addObject("message", "This page is for ROLE_ADMIN only!");
    model.setViewName("admin");

    String fullName = ...; // Add the required logic to get the full name.
    model.addObject("FullName", fullName); // Then add the fullName to your model object

    return model;

}