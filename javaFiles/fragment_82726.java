@Entity
public class NewsDict {

  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String name;

  @OneToMany(mappedBy = "newsDict")
  private List<NewsItem> newsItems;

}

@Entity
public class NewsItem {

  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String name;

  @Column
  private String data;

  @ManyToOne(fetch = FetchType.LAZY)
  private NewsDict newsDict;

}