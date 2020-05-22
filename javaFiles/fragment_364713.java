@Data
public class Comment implements Persistable<Long>, CBHistoryTable
{
    @Id
    private Long tid;
    // sid and pid is required for serialized to json
    private Long pid;
    private Long sid;

    @DatabaseField(canbenull = true, foreign = true, foreignColumnName = "sid")
    private Article article;

    @DatabaseField(canbenull = true, foreign = true, foreignColumnName = "tid")
    private Comment parent;

    @ForeignCollectionField(foreignFieldName = "parent")
    private Collection<Comment> comments = Sets.newHashSet();

    public void setArticle(Article article) {
        this.article = article;
        sid=article.getSid();
    }

    public void setParent(Comment parent) {
        this.parent = parent;
        pid=comment.getTid();
    }
}

@Data
@DatabaseTable(daoClass = ArticleServiceImpl.class)
public class Article implements Persistable<Long>, CBHistoryTable
{
    @Id
    @SerializedName("SID")
    private Long sid;

    @SerializedName("SN")
    private String sn;

    @ForeignCollectionField(foreignFieldName = "article")
    private Collection<Comment> comments = Sets.newHashSet();
}