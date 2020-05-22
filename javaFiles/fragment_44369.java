@Component
@Entity
public class SigningOrder implements Serializable {

    @Autowired
    private SigningOrderRepository repository;

    @GeneratedValue
    private int id;

    private List<Subject> listOfSubjects;

    private List<String> authenticationMethods;

    private List<String> signingMethods;

    private List<Notification> listofNotifications;

        //Getters and setters
    }