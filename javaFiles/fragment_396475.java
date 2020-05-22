@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ContractorType")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "contact_no", unique = true, nullable = false)
    private String contactNo;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    private String address;
}