@RequestMapping( value="/find", method = RequestMethod.GET )
    public String search(@ModelAttribute("Person") Person p,BindingResult result,ModelMap model){

         Person person2 = personDao.get( p.getId() );
         PersonValidator personValidator = new PersonValidator();
         Errors errors = new BeanPropertyBindingResult(person2, "person");
         personValidator.validate(person2, errors);
         model.addAttribute("person",person2);
         model.addAttribute("errors",errors);

         return "templates/person";
 }