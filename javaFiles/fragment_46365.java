@Entity
@Table(name = "tbl_media")
public class Media implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String mediaID;
    private String mediaType;
    private String mediaUrl;
    private String mediaUrlHttps;
    private String mediaVideoUrl;
    @Transient
    @JoinColumn(name = "tweetID")
    private Tweet tweet;