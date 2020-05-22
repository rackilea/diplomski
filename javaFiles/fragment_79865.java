@Entity
@Table(name="answer")
public class Answer implements Serializable {

    //turns out having a primary key on the answer table is actually useful
    //for the application logic. would you look at that
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long mId;

    @Column(name="answer_text")
    private String mAnswer;

    //got rid of long mPollId
    //it was for the same reason i did in the Post class
    //hibernate does the work for me with the mPoll object and the
    //annotations i've provided on it

    //made the relationship between a poll and its answers bidirectional
    //not entirely sure how adding the below annotations to the new
    //Poll field fixed my problems, but it did
    //i imagine it somehow tells hibernate that the primary key
    //for the below object is the foreign key represented by poll_id in the
    //database table for this entity
    //and making insertable=true enables hibernate to insert that foreign
    //key into the appropriate column in the database when this entity
    //is saved
    //updatable seemed to be necessary
    //hibernate complained when it wasn't there
    //and nullable was in the helpful examples i found so it was copy and
    //pasted along with the rest of the helpful stuff here
    //this field can't be nullable anyways so semantically, it makes sense
    //for it to be there
    @ManyToOne
    @JoinColumn(name="poll_id", nullable = false, insertable=true, updatable=false)
    private Poll mPoll;