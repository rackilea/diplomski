@RequestMapping(value = "/employees/find", method = RequestMethod.GET)
public String getEmployee(@RequestParam("empNo") long empNo, Model model){
    Employee employee1=this.employeeService.findEmployeeById(empNo); 
    model.addAttribute(employee1);
    return "employees/find";
}