@Entity
public class Employee {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "servedBy")
    private List<Orders> orders;

}