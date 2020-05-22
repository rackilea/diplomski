public class Article extends RealmObject{
    @PrimaryKey
    private String aID = UUID.randomUUID().toString();
    private RealmList<Tags> tags;

    @LinkingObjects("article")
    private final RealmResults<ArticleTagsRelation> articleOfRelation = null;
}

public class Tags extends RealmObject{
    @PrimaryKey
    private String tID = UUID.randomUUID().toString();
    private String tag;

    @LinkingObjects("tag")
    private final RealmResults<ArticleTagsRelation> tagOfRelation = null;
}

public class ArticleTagsRelation extends RealmObject{
    private Tags tag;
    private Article article;
    private long timesArticleSelectedByTag; 
}

realm.where(Article.class)
     .equalTo("tags.tag", userSearch)
     .findAllSorted("articleOfRelation.timesArticleSelectedByTag", Sort.DESCENDING);