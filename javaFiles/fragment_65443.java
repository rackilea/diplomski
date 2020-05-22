@XmlRootElement(
    name = "users"
)
public class UserEntities {
    List<UserEntity> users;

    public UserEntities() {
    }

    public UserEntities(List<UserEntity> users) {
        this.users = users;
    }

    @XmlElement(
        name = "user"
    )
    public List<UserEntity> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}