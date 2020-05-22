@Named("contactsController")
@SessionScoped
public class ContactsController implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Contact> contacts;

    @Inject
    private ContactsDAOImp contactsDAOImp;

    public ContactsController() { }

    public List<Contact> getContacts() {
        return contacts;
    }

    @PostConstruct
    public void init() {
        this.contacts = contactsDAO.getAllContacts();
    }
}