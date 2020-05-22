@Bean //This bean is singleton by default
@Qualifier("employeeServiceA")
public EmployeeService employeeServiceA() {
    new EmployeeService();
}

@Bean
@Qualifier("employeeServiceB")
@Scope("prototype")
public EmployeeService employeeServiceB() {
    new EmployeeService();
}