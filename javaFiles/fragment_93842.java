@Entity
public class Employee {
    ...
    @Basic
    @Temporal(DATE)
    private Calendar startDate;
    ...
}