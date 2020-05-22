public class Department {
   private final List<Employee> employees;
   private final String name;

   public Department(final String name) {
      this.employees = new ArrayList<Employee>();
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public List<Employee> getEmployees() {
      return employees;
   }

   public int getEmployeeCount() {
      return employees.size();
   }

   public void addEmployee(final Employee employee) {
      employees.add(employee);
   }
}