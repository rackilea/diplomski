@Entity
public class Employee {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "servedBy" , cascade={CascadeType.ALL})
    private List<Orders> orders;

}