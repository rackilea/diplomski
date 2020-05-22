public class Account {

    private Integer id;

    private Integer accountNumber;

    @Id
    public Integer getId() {
        return this.id;
    }

    @Column(nullable=false)
    public Integer getAccountNumber() {
        return this.accountNumber;
    }

}