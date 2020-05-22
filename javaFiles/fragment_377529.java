@Entity
public class Account {

    private Integer id;

    private Integer accountNumber;

    @Id
    @Column(name="ACCOUNT_NUMBER")
    public Integer getId() {
        return this.id;
    }

    @Column(name="ACCOUNT_NUMBER")
    public Integer getAccountNumber() {
        return this.accountNumber;
    }

}