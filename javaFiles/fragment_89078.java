@Entity
@Table(name="`Group`") // Change your table name
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private long id;

    @NotNull
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="Admin", referencedColumnName="Id")
    private User admin;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "Group_User", 
        joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"), //Give a column name 'group_id' and map it to Group primary key id
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id") //Give a column name 'user_id' and map it to User primary key id.
    )
    private Set<User> members;

    ...

}