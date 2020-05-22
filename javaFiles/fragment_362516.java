@Entity
@Table(name = "users_x_converations", uniqueConstraints =
        @UniqueConstraint(columnNames={"converation_id", "user_id"}))
public class UserConversation extends BaseEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "conversation_id", nullable = false, updatable = false)
    Conversation conversation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    User user;

    // Ctors, getters & setters down here...
}