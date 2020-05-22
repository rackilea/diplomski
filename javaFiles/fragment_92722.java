@Entity
@Table(name = "comments")
public class Comment implements Serializable{

    @Id
    @Column(name = "commentId")
    private Integer commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topicId", referencedColumnName = "topicId")
    private Topic topic;