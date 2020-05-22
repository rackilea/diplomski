@Entity
@Table(name="poll")
public class Poll implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long mId;

    @Column(name="user_id")
    private long mUserId;

    @Column(name="question")
    private String mQuestion;

    @Column(name="date_created")
    private Date mDateCreated;

    //removed @JoinColumn -- not completely sure about why it wasn't
    //helping, but many of the examples similar to my use case didn't
    //use it so I got rid of it
    //added mappedBy variable -- still not really sure what it does
    //but it works
    //and added FetchType.EAGER so everytime a Poll object is loaded
    //the answers it's associated with are loaded too
    @OneToMany(mappedBy="mPoll", fetch=FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    private List<Answer> mAnswers;