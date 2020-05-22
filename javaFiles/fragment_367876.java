@PostMapping("/department")
public String postDepartment(@Valid Department department,
                             BindingResult result) {
    if (result.hasErrors()) {
        //add error information here
        model.addAttribute("isReadOnly", true); 
        return "department"
    } 
    departmentService.updateDepartment(department);
    return "redirect:/departments";
}