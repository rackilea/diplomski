@Entity
@Table(name="BAND_HAS_MUSICISTA")
@AssociationOverrides({
    @AssociationOverride(name = "pk.musicista", 
        joinColumns = @JoinColumn(name = "MUSICISTA_ID")),
    @AssociationOverride(name = "pk.band", 
        joinColumns = @JoinColumn(name = "BAND_ID")) })
@NamedQuery(name="BandHasMusicista.findAll", query="SELECT b FROM BandHasMusicista b")
public class BandHasMusicista implements Serializable {
    private static final long serialVersionUID = 1L;

    private BandHasMusicistaPK pk = new BandHasMusicistaPK();

    @Column(name="BAND_ACCEPT", nullable=false)
    private boolean bandAccept;