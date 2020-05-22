@Entity
@Table(name = "tbl_tweet")
public class Tweet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true,nullable = false,name = "tweetID")
    private String tweetID;
    private String parentTweetID;
    private String avatar;
    private long owner_id;
    private String owner_name;
    private String owner_nick;
    private String content;
    private String sent_time;
    private String sent_date;
    private String retweet_count;
    private String like_count;
    @Transient
    private String quotedTweetHtml;
    @Transient
    @JoinColumn(name = "threadid",referencedColumnName = "id")
    private Thread thread;


    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "tweetID")
    private List<Media> mediaURLs;