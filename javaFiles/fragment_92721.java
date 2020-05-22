@Entity
@Table(name = "topics")
public class Topic implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "topicId")
    private Integer topicId;

    @OneToMany(mappedBy = "topic", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Comment> comments;