@Entity
@PrimaryKeyJoinColumn
public class ValuedCustomer extends Customer {

    @Column
    private String valuedCustomerName;

    }

}