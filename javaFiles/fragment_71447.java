@Entity
@IdClass(JoinTableId.class)
public class JoinTable {
  @Id
  private long entityCId;
  @Id
  private long entityDId;
  ...
  private int entityTypeId;     //your relationship-attribute
  ...
  @ManyToOne
  @JoinColumn(name="entityCId", referencedColumnName="id", updatable="false", insertable="false")
  private EntityC entityC;
  @ManyToOne
  @JoinColumn(name="entityDId", referencedColumnName="id", updatable="false", insertable="false")
  private EntityD entityD;
  ...
}

public class JoinTableId implements Serializable {
    private long entityCId;
    private long entityDId;
    ...
    //hashCode()
    //equals(...)
}