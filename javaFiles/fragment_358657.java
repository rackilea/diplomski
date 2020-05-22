@Entity
public class Customer extends AbstractDomainClass {
    //other attributes...
    @Embedded
    @AttributeOverrides(
        @AttributeOverride(
            name = "addressLine1",
            column = @Column(name = "billingAddressLine1"),
        )
        //do similar for the other attributes...
    )
    private Address billingAddress;
    @Embedded
    @AttributeOverrides(
        @AttributeOverride(
            name = "addressLine1",
            column = @Column(name = "shippingAddressLine1")
        )
        //do similar for the other attributes...
    )
    private Address shippingAddress;
}