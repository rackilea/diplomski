@Canonical
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type="uuid-binary")
    private UUID refId;

    // Getters/setters/ctors/etc.
}

@Entity(name = "accounts")
@AttributeOverrides({
    @AttributeOverride(name = "id", column=@Column(name="account_id")),
    @AttributeOverride(name = "refId", column=@Column(name="account_ref_id"))
})
public class Account extends BaseEntity {
    // blah whatever
}