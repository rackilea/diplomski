@Entity
public class Buyer extends User {

    @OneToOne(optional=true, cascade= {CascadeType.MERGE})
    @JoinColumn(nullable=true, unique=true)
    private ExternalAccount externalAccount;
    //getters and setters

}