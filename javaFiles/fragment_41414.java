public class EmployeeComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee e1, Employee e2) {
    int nameDiff = e1.getName().compareTo(e2.getName());

    if(nameDiff != 0) {
      return nameDiff;
    }

    int ageDiff = e1.getAge() - e2.getAge();

    if(ageDiff != 0) {
      return ageDiff;
    }

    int idDiff = e1.getEmpId() - e2.getEmpId();

    return idDiff;
  }
}