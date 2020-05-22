public class Employees{
     @ManyToOne
     @JsonManagedReference
     private Departments departments;
}
public class Departments {
     @OneToMany(mappedBy = "departments")
     @JsonBackReference
     private List<Employees> employeesList; 
}