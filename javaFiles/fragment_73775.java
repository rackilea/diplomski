public class Employee implements Comparable<Employee> {

    ....

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.getId(), o.getId());
    }
}