@Entity
@Table(name = "articles")
public class Article {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @BatchFetch(BatchFetchType.IN)
    private List<Author> authors

    //+ setters and getters
} 

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articleId")
    private Article article;

    @Column(name = "surname")
    private String surname;

    //+setters and getters
}