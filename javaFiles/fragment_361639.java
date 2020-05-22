import java.math.BigDecimal;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
public class IndividualCustomer extends BaseCustomerDemographicDetails {

    @NotNull
    @Embedded
    private PersonalInformation personalInformation;

    @Column(precision = 16, scale = 2)
    private BigDecimal annualIncome;

    private Boolean vip;

    private Boolean isStaff;

}