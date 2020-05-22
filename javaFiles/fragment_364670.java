@Entity
public class Document {

    @Id
    private Long id;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "document_inbox", joinColumns = @JoinColumn(name = "userinbox_id"),
               inverseJoinColumns = @JoinColumn(name = "inbox_id"))
    private List<User> userinbox  = new ArrayList<User>();
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "document_outbox", joinColumns = @JoinColumn(name = "useroutbox_id"),
               inverseJoinColumns = @JoinColumn(name = "outbox_id"))
    private List<User> useroutbox  = new ArrayList<User>();

}