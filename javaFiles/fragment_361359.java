@Entity
@Table(name = "article")
public class Article{
    private String author;
    private String body;
    private int commentCount;

    @OneToMany(mappedBy = "article")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<EntryComment> comments;