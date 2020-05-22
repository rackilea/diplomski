@Entity
@Table(name = "triple")
public class TripleDBModel {

  @EmbeddedId
  private TripleId id;
  ...
}