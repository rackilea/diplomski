@Entity
@Table(name = "comments")
public class Comment{

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    private String author;
    private String body;
    private int voteCount;