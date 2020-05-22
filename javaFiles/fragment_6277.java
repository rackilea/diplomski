@Entity
@Table(name = "ORDER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "STATUS", discriminatorType = DiscriminatorType.STRING)
public abstract class Order{
}


@Entity
@DiscriminatorValue(value = "PENDING")
public class PendingOrder extends Customer {

}

public class Customer{
    //Irrelevant stuff from above...

    private Set<PendingOrder> pendingOrders;
    //same fo0r all others types
}