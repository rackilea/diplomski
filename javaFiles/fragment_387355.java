@Entity
public class Employee {
    //...
    private String name;
    //...
    @OneToMany
    private List<Shift> shifts;
    //...
    public Employee(String name) {
        this.name = name;
    }
    //...
    public setShifts(Shift... shifts) {
        this.shifts = Arrays.asList(shifts);
    }
    //...
}