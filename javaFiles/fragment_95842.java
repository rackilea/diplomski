@Entity
@Table(name="userProfile")
public class UserProfile extends BasePojo {

@Enumerated(EnumType.STRING)
@Column(name="type", length=15, unique=true, nullable=false)
private UserProfileType type = UserProfileType.USER;

// getter and setter