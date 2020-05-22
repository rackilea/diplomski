package example;
...
@Entity
@Indexed
public class Book {

  @Id
  @GeneratedValue
  private Integer id;

  @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
  private String title;

  @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
  private String subtitle;

  @Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES)
  @DateBridge(resolution=Resolution.DAY)
  private Date publicationDate;

  @IndexedEmbedded
  @ManyToMany
  private Set<Author> authors = new HashSet<Author>();
  public Book() {
  }

  // standard getters/setters follow here
  ...
}