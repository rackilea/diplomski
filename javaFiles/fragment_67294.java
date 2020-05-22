public class Deposit {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    protected long id;
    protected String depositNumber;
    @OneToMany
    protected Set<Credit> credits;
    @OneToMany
    protected Set<Transfer> transfers;

    @ManyToOne
    private Person person;
}