public class MyComparator implements Comparator<Employee> {

@Override
public int compare(Employee emp1, Employee emp2) {

    String s = emp1.name;

    if (emp1.getSalary() < emp2.getSalary()) {
        return -1;
    } else if (emp1.getSalary() == emp2.getSalary()) {
        return 0;
    } else
        return 1;

   } // compare method

}