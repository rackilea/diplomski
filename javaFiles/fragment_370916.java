@Entity
@Table(name = "company_service")
@IdClass(CompanyServicePK.class)
public class CompanyService implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
    @JoinColumn(name = "company_id")
    private Company company;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Service.class)
    @JoinColumn(name = "service_id")
    private Service service;

    @Column
    private String description;
}