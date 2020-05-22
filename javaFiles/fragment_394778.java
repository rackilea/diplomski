@Embeddable
public class CandidateId implements Serializable {
    @Column(name = "PERIODE")
    // instead of class Periode put here field period of the same type as field debut in class Periode
    private Date period; 


@Table(name = "ECHEANCIER_FISCAL_PERSONNE")
public class Candidate {
    // Fields
    @EmbeddedId
    private CandidateId id;
    // add following:
    @Embedded
        @AttributeOverrides({
            @AttributeOverride(name = "debut", column = @Column(name = "PERIODE", nullable = false, insertable = false, updatable = false) ),
            @AttributeOverride(name = "fin", column = @Column(name = "PERIODE", nullable = false, insertable = false, updatable = false))
        })
    Periode period;