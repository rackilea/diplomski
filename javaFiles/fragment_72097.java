@Entity
@Table(name = "users")
public class User {

@OneToMany(mappedBy = "senderUser",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<Message> sentMessages;

@OneToMany(mappedBy = "recipientUser",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<Message> receivedMessages;