@Entity
public class Seller extends User {

    @OneToOne(optional=false, cascade= {CascadeType.MERGE})
    @JoinColumn(nullable=false, unique=true)
    private ExternalAccount externalAccount;
    //getters and setters

}