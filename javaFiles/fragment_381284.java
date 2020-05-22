@Entity
public class Person{
    @Id
    private Long id;
    @OneToOne(optional=true)
    private Employee employee;
    @OneToOne(optional=true)
    private Parent parent;
    public boolean isParent(){return parent!=null;}
    public boolean isEmployee(){return employee!=null;}
}
@Entity
public class Employee{
    @Id
    private Long id;
    @OneToOne(mappedBy="employee",optional=false)
    private Person person; 
}
@Entity
public class Parent{
    @Id
    private Long id;
    @OneToOne(mappedBy="parent",optional=false)
    private Person person; 
}