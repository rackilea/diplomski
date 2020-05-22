@Entity
  @Table(name = "Group")
  public class Group 
  {
    @Id
    @GeneratedValue(GenerationType=AUTO)
    private Integer group_id;

    Addressbook addressbook;
    //----bidirectional association
    @ManyToMany
    private List<Contact> contacts = new ArrayList<Contact>();
    //----
  }