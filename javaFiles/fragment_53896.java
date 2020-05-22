public class Department {
  private Department(String departmentName, int moneyForDepartment) { ... }
  ...
  public static class Factory {
     private Set<String> seenDepartmentNames = new HashSet<>();
     public Department create(String departmentName, int moneyForDepartment) {
        if (!seenDepartmentNames.add(departmentName)) {
          throw new IllegalArgumentException("Department already created");
        }
        return new Department(departmentName, moneyForDepartment);
     }
  }
}