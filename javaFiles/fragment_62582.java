@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PAYMENT_TYPE")
@DiscriminatorValue("PAYMENT")
public class Payment { ... }

@Entity
@DiscriminatorValue("CREDIT")
@SecondaryTable(name="CREDIT_PAYMENT", pkJoinColumns={
    @PrimaryKeyJoinColumn(name="payment_id", referencedColumnName="id")
)
public class CreditCardPayment extends Payment { ... }

@Entity
@DiscriminatorValue("CASH")
public class CashPayment extends Payment { ... }