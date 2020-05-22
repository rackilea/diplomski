@RequestMapping(value="/addCaregiver", method= RequestMethod.POST)
public String addCaregiver(@ModelAttribute("caregiver") @Valid  
Caregivers caregiver, BindingResult result,Principal principal, Model model){


caregiverValidator.validate(caregiver, result);
if(result.hasErrors()){

model.addAttribute("caregivers",pp.getCaregiverses(principal.getName()));
model.addAttribute("error", "true");
model.addAttribute("caregiver", new Caregivers());
return "caregiver";
        }
return "intro";
}