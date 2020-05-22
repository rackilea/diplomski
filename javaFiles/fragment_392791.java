@Embeddable
public class UserRoleId implements java.io.Serializable
{

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "role_id", nullable = false)
    private long roleId;

    public UserRoleId()
    {
    }

    public UserRoleId(long userId, long roleId)
    {
        this.userId = userId;
        this.roleId = roleId;
    }


    //hashcode equal


}