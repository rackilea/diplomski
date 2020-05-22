//@Embedded
@Entity
public class Address extends AbstractDomainClass {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;

    //new fields...
    private int addressType;
    @ManyToOne
    private Customer customer;
    // getters and setters ...
}

@Entity
public class Customer extends AbstractDomainClass {
    //other attributes...
    @OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
    private Address billingAddress;
    @OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
    private Address shippingAddress;
    //getters and setters...
}