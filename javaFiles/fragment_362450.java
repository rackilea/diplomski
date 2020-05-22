// parent entity has simple primary key

@Entity
public class Employee {
   @Id long empId;
   String name;
   ...
} 

// dependent entity uses EmbeddedId for composite key

@Embeddable
public class DependentId {
   String name;
   long empid;   // corresponds to primary key type of Employee
}

@Entity
public class Dependent {
   @EmbeddedId DependentId id;
    ...
   @MapsId("empid")  //  maps the empid attribute of embedded id
   @ManyToOne Employee emp;
}