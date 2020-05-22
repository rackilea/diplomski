@Entity
@Table(name = "news")
public class News extends BaseNews implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_similar",
               joinColumns = {@JoinColumn(name = "base_news_id")},
               inverseJoinColumns = {@JoinColumn(name = "similar_news_id")}
    )
    private List<News> similarNews;

   //getters, setters...
}