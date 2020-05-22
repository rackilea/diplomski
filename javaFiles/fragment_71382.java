@Entity
@Table(name="SHARES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_DISCRIMINATOR", discriminatorType=DiscriminatorType.STRING)
public abstract class Share {
    @Id
    @Column( name="ID", nullable=false )
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne
    @JoinColumn( name="SHARED_BY", nullable=false )
    private User sharedBy;

    @ManyToOne
    @JoinColumn( name="SHARED_WITH", nullable=false )
    private User sharedWith;

    @Column(name="SHARED_DATE", columnDefinition="TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sharedDate;        
    ...

}