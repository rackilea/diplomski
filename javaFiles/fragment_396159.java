@Entity
@Table(name="Photos_Users")
public class PhotosUsersEntity implements Serializable {

@EmbeddedId
private PhotosUsersEntityKey compositePrimaryKey;

//rest
}