@Path("jaxbResource")
@Produces("application/xml")
@Consumes("application/xml")
public class UserResource {
    @GET
    public User[] getUserArray() {
    List<User> userList = new ArrayList<User>();
    userList.add(new User(1, "John"));
    ………
    return userList.toArray(new User[userList.size()]);
    }
}

@XmlRootElement
public class User {
    private int id;
    private String name;

    public User() {}

    public User(int id,String name) {
        this.id = id;
        this.name = name;
    }
    ………
}