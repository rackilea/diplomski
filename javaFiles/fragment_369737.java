@Entity
@Table(name = "INT_ACCOUNTS",
       uniqueConstraints=@UniqueConstraint(columnNames={"ACC_ID", "INT_ID"}))
public class IntegrationAccount  {

    @Id
    private Long id;

    @JoinColumn(name = "ACC_ID", referencedColumnName = "ACC_ID", insertable = false, updatable = false)
    @ManyToOne
    private Account account;

    @JoinColumn(name = "INT_ID", referencedColumnName = "INT_ID", insertable = false, updatable = false)
    @ManyToOne
    private Integration integration;
...
}