@RequestMapping(method=RequestMethod.POST)
public String getRegistration(@Valid UserRegistration userRegistration, BindingResult result, HttpSession session, ModelMap model) {
    if (result.hasErrors()){
        model.addAttribute("errorMsg", "Your form submission contains errors.");
        return "formPage"; 
    }

    model.addAttribute("successMsg", "Form successfully submitted");
    return "successPage";
}