@Root(name="UserList")
public class UserList{


    @ElementList(name="UserLists", entry="user")
    public List<UserInfo> user;

    public List<UserInfo> getUsers(){
        return user;
    }
}