Employee emp = new Employee();
emp.setHourlyWage(12.5);
emp.setHoursWorked(100);

List<Employee> employees = new ArrayList<Employee>();
employees.add(emp);

for(Employee e : employees){
  System.out.println(e.getAnnualGrossSalary());
}