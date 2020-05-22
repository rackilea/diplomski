public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MACHINE_SEQUENCE")
    private int id;

    // ... 
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name = "client_id", nullable = false)
    @Valid // REMOVED
    private Client client;