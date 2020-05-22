@Table
@Entity
@BatchSize(size = 50)
@PersistenceContext(unitName = "default")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Tag")
class Tag(
    name: String,
) : Serializable {