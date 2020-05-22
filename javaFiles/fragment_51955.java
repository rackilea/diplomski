@Entity
@Table(name="emergency_messages")
@HomePageEmptyMessage(message="Home page annoucement cannot be empty if the Display  Announcement is set to Yes")
public class EmergencyMessages implements Serializable {

private static final long serialVersionUID = -7870767517772161300L; 

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id", nullable=false)
private Integer id; 

@Column(name="home_page_message")
private String homePageMessage;

@Range(min=0, max=1, message="Please select one of the display announcement value")
@Column(name="messages_enabled")
private Integer messagesEnabled;
}