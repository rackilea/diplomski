@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotNull
    private String username;

    @ManyToMany(mappedBy = "users")
    // this is the non-owning side of the relationship; the join table mapping
    // is declared on the other side
    private Set<Conversation> conversations;

    // Ctors, getters & setters down here...
}