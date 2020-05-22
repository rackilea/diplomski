import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.FIELD)
@Table(name = "GROUP_OF_CUSTOMERS")
public class Group {

    protected Group() {
    }

    @Id
    @NotNull
    @Column(name = "GROUPID")
    private String groupId;

    @NotNull
    @Column(name = "GROUPNAME")
    private String groupName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupOfCustomers")
    private List<BaseCustomerDemographicDetails> customerDemographicDetails;

}