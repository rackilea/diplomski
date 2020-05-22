@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity extends AbstractAuditable<User, Long> implements Serializable {
  @javax.persistence.Version
  private Long version;
}