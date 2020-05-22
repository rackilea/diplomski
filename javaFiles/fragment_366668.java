@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "name")  
    private String name;

    @Column(name = "number")  
    private Long number;

    @Column(name = "updated_at")  
    @Temporal(TemporalType.TIMESTAMP)  
    private Date updatedAt;  

    // getter setter

    @PreUpdate  
    public void setChangeDate() {  
       this.updatedAt = new Date();  
    }  

}