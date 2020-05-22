@Entity
@Table(name = "converations")
public class Conversation extends BaseEntity {
    @Column(name = 'conversation_created_on')
    @NotNull
    private Date createdOn;

    @ManyToMany(mappedBy = "conversations")
    @JoinTable(name = "users_x_conversations",
        joinColumns = @JoinColumn(name="conversation_id", nullable = false, updateable = false),
        inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false, updateable = false)
    )
    private Set<User> users;

    // Ctors, getters & setters down here...
}