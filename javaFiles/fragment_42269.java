@RequestMapping(method=RequestMethod.POST)
public String getRegistration(UserRegistration userRegistration, HttpSession session, ModelMap model) {
    boolean result = validateAndSaveData(userRegistration);
    if (result){
        model.addAttribute("successMsg", "Form successfully submitted");
        return "successPage";
    }
    else {
        model.addAttribute("errorMsg", "Your form submission contains errors.");
        return "formPage";  
    }
}