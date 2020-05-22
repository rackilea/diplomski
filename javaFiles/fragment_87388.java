@Entity
public class Association {

  @Id
  @GeneratedValue(...)
  private Long id;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date affectation;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date expiration;

  @ManyToOne(fetch=FetchType.LAZY)
  private Entity1 entity1;

  @ManyToOne(fetch=FetchType.LAZY)
  private Entity2 entity2;
}