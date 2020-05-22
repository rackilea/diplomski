@Entity
@Table(name = "topics")
public class Topic implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

     @ManyToMany
     @JoinTable(name="COMMON",
        joinColumns=@JoinColumn(name="TOPIC_ID"),
        inverseJoinColumns=@JoinColumn(name="COMMENT_ID"))
    private List<Comment> comments;