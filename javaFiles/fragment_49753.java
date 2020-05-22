@Entity
public class Customer {
    // Instead of "refId" field:
    @OneToOne(mappedBy = "customer")
    private Account account;
}

@Entity
public class Account {
    // Instead of "refId" field:
    @OneToOne
    @JoinColumn(name = "refIdColName")
    private Customer customer;
}