@Entity
@Table(name = "comments")
public class Comment implements Serializable{

    @Id
    @Column(name = "commentId")
    private Integer commentId;

    @ManyToMany
     @JoinTable(name="COMMON",
        joinColumns=@JoinColumn(name="COMMENT_ID"),
        inverseJoinColumns=@JoinColumn(name="TOPIC_ID"))
    private Topic topic;