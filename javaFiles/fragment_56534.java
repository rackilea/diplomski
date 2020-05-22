@Entity
@Table(name="TOPICS")
public class Topic implements Serializable {

    @Id
    @GeneratedValue
    private long topicId;      

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TOPIC_SPEAKERS",
    joinColumns = {
        @JoinColumn(name = "topicId")},
    inverseJoinColumns = {
        @JoinColumn(name = "speakerId")})
    private Set<Speaker> speakersList;




@Entity
@Table(name="SPEAKERS")
public class Speaker implements Serializable {

    @Id
    @GeneratedValue
    private long speakerId;

    @ManyToMany(mappedBy = "speakersList")
    private Set<Topic> topics;

    private String speakerName;