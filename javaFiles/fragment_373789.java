@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String companyName;

    @Column
    private double estimatedAnnualEarnings;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="mainCompanyId")
    private Company mainCompany; 

    @OneToMany(mappedBy="mainCompany")
    private List<Company> subsidiaryCompanies; 

    //getters and setters goes here
}