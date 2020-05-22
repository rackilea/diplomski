@Entity
@Table(name = "Sessions", catalog = "TestMvn")
public class SessionRiu extends Base implements java.io.Serializable {

    @Id
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Agent agent;

    //other mappings here

}