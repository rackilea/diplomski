Employee bill = new Employee("Bill", 60, "Micro$oft");
Employee appleBill = new Employee("Billie", 60, "Apple");
List<Employee> employees = newArrayList(bill, appleBill);

Employees[] expectedEmployees = { new Employee("Bill", 60, "Google"), 
                                  new Employee("Billie", 60, "Facebook") };
// this assertion succeeds as we don't compare the company field.     
assertThat(employees).usingElementComparatorIgnoringFields("company")
                     .contains(expectedEmployees);