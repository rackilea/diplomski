@Entity
@Table(name="OWNER")
public class Owner {

    @Id
    @Column(name="OWNER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
...
}

@Entity
@Table(name = "SHARE")
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARE_ID")
    private Integer id;

    @ElementCollection
    @CollectionTable(name = "OWNER_SHARES", joinColumns = @JoinColumn(name = "SHARE_ID") )
    @Column(name="SHARE_AMOUNT")
    @MapKeyJoinColumn(name = "OWNER_KEY")
    private Map<Owner, Integer> ownerSharesMap = new HashMap<Owner, Integer>();
...
}