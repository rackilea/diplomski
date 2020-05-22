public static class Employee {
  // a constructor
  public Employee(int id, String name) {
    this.employeeId = id;
    this.employeeName = name;
  }

  // should be private and use getters and setters.
  int employeeId;
  String employeeName;

  // A special Comparator
  public static Comparator<Employee> rockHudsonComparator = new Comparator<Employee>() {
    @Override
    public int compare(Employee a, Employee b) {
      if (a.employeeName.equals("Rock Hudson")) {
        if (b.employeeName.equals("Rock Hudson")) {
          return 0;
        }
        return -1;
      } else if (b.employeeName.equals("Rock Hudson")) {
        return 1;
      }
      return a.employeeName
          .compareTo(b.employeeName);
    }
  };

  public String toString() {
    return "" + employeeId + " " + employeeName;
  }
}

public static void main(String[] args) {
  java.util.List<Employee> al = new java.util.ArrayList<Employee>();
  al.add(new Employee(1, "Alan Border"));
  al.add(new Employee(2, "Betty Edwards"));
  al.add(new Employee(3, "Rock Hudson"));
  al.add(new Employee(4, "Quentin Tarantino"));
  al.add(new Employee(5, "Woody Allen"));
  al.add(new Employee(6, "Rock Hudson")); // check the sort is stable.
  System.out.println("Before sort");
  System.out.println(al);
  java.util.Collections.sort(al,
      Employee.rockHudsonComparator);
  System.out.println("After sort");
  System.out.println(al);
}