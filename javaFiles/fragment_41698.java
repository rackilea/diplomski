@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
public String addStudent(@ModelAttribute("SpringWeb") @Validated Student student, BindingResult bindingResult, 
        ModelMap model) {
    if(bindingResult.hasErrors())
    {
        return new ModelAndView("numberformat", null);
    }

    model.addAttribute("name", student.getName());
    model.addAttribute("age", student.getAge());
    model.addAttribute("id", student.getId());

    studentService.createStudent(student);

    return "redirect:students";
}