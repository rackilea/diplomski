@Entity
public class EmployeeStatus{
   @Id //this is your pk?
   private int statusID;
   private String statusDesc;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "empStatus", fetch = FetchType.LAZY) //or EAGER
   private List<Employee> empList;

   //getters and setters
}