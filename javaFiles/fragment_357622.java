@Entity
  @Table(name = "Contact")
  public class Contact 
  {

    @Id
    @GeneratedValue(GenerationType=AUTO)
    private Integer contact_id;

    Addressbook addressbook;

    //----bidirectional association
    //@ManyToMany
    //private List<Group> groups = new ArrayList<Group>();
    //----
  }