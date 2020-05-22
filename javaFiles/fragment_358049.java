ITRelationships.java
@Entity
@Table(name = "IT_RELATIONSHIPS")
public class ITRelationships implements Serializable {

    @Id
    @Column(name = "ClientID",nullable = false, length = 7)
    private String clientID;

    @OneToOne
    @JoinColumn(name="ClientAccountNo")
    private ICareCallReport careCallReport;

    ....