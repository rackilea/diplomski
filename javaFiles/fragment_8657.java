@RequestMapping(value = { "/register/registerStudent" }, method = { RequestMethod.GET, RequestMethod.POST })
public String registerSubmit(@Valid  @ModelAttribute StudentVO student, BindingResult result, Model model, HttpServletRequest request,
    @RequestParam String action, @RequestParam(value = "parentID", required = false) String parentID,
    @RequestParam(value = "studentID", required = false) String studentID,
    RedirectAttributes redirectAttributes) {
if(result.hasErrors()){
    model.addAttribute("student", student);
    List<Map<String, String>> age = lookupService.getFields("age");
    model.addAttribute("age", age);
    return "studentSignup";
}