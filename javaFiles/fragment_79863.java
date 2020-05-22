@Entity
@Table(name="user_feed")
public class Post implements Serializable {
    @Id
    @Column(name="user_id")
    private long mUserId;

    //removed long mPollId
    //hibernate is capable of getting the foreign key for a post's
    //poll_id column from its poll object -- mPoll
    //so i don't have to have a separate field for the id of this post's
    //poll

    @Column(name="is_repost")
    private boolean mIsRepost;

    @Column(name="date_created")
    private Date mDateCreated;

    //made this field part of the composite id instead of long mPollId
    //pretty much the same composite key as before just had to alter
    //my implementation of Post.equals(Object) to use this poll's id
    //instead of this class's mPollId field
    //implementing your own .equals(Object) method is necessary when
    //creating composite keys as i do with multiple @Id annotations
    //i think you also have to implement your own .hashCode() method too
    //but the word hash scares me, so I didn't do it
    //the code works, so i'm just gonna let it rock
    @OneToOne
    @JoinColumn(name="poll_id")
    private Poll mPoll;