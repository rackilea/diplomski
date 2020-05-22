@Autowired
EmployeeRepository employeeRepository;

@PostMapping("/api/employee/save")
public Employee createEmployee(@Valid @RequestBody List<Employee> lstEmployee) {
        return employeeRepository.saveAll(lstEmployee);
}