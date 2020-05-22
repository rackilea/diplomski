import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "BaseCustomerDemographicDetails")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseCustomerDemographicDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @ManyToOne
    @JoinColumn(name = "GROUP_OF_CUSTOMERS")
    protected Group groupOfCustomers;

}