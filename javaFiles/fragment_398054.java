@Entity
public class Employee{
   //other private instance

   @JoinColumn(name = "empStatus", referencedColumnName = "yourColName")
   @ManyToOne(optional = false)
   private EmployeeStatus empStatus;

   //getters and setters.
}