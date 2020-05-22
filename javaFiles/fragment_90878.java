@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "someDiscriminator")
public class Customer {

    @Id
    @GeneratedValue
    private Long customerPid;

    @Column
    private String customerName;

}

@Entity
@PrimaryKeyJoinColumn(name = "xxxYY")
public class ValuedCustomer extends Customer {

    @Column
    private String valuedCustomerName;

}