@Entity
@Table("person")
public class Employee implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable=false)
    private String name;

    private String country;

}