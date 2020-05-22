@Entity
@Table( name = "contract" )
@SequenceGenerator( name = "CONTRACT_SEQ_GEN", sequenceName = "CONTRACT_SEQUENCE" )
public class Contract implements DataObject<Long> {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "CONTRACT_SEQ_GEN" )
    private Long key;
    ...
    @ManyToOne( optional=false )
    @JoinColumn( name="organization_key" )
    private Organization organization;
    ...
}