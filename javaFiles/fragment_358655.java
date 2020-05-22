@Entity
public class Customer extends AbstractDomainClass {
    //other attributes...
    @Embedded
    private Address billingAddress;
    @Embedded
    private Address shippingAddress;
}