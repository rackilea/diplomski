@Entity
@Table(name="Users", catalog = "TestMvn")
public class User extends Base implements java.io.Serializable {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="user")
    private List<SessionRiu> sessions = new ArrayList<>();

    //other mappings here

}

@Entity
@Table(name="Agents", catalog = "TestMvn")
public class Agent extends Base implements java.io.Serializable {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="agent")
    private List<SessionRiu> sessions = new ArrayList<>();

    //other mappings here
}