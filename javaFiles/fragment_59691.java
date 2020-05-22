@Entity
@Table(
    name="Ranking",
    indexes = { @Index(name="ranking_ix", columnNames = { "Rankable", "Criteria" } ) }
    )
public class Ranking extends Model {
    @ManyToOne
    public Rankable rankable;

    @ManyToOne
    public Criteria criteria;

    @Index(name = "ranking_ix")
    public double rank;
}