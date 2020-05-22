public class NewsRequest extends BaseGetRequest<NewsArticle.List, NewsArticle, API> {

    public static final String TARGET_URL = "/news";
    NewsArticleDao mNewsArticleDao;

    public NewsRequest(Context context) {
        this(context, null);
    }

    public NewsRequest(Context context, Map<Property, String> filterMap) {
        super(NewsArticle.List.class, API.class, context, filterMap);
        mNewsArticleDao = mSessionProvider.getDaoSession().getNewsArticleDao();
    }

    @Override
    public AbstractDao<NewsArticle, Long> getDao() {
        return mNewsArticleDao;
    }

    @Override
    public NewsArticle.List createDataList(List<NewsArticle> list) {
       return new NewsArticle.List(list);
    }

    @Override
    public NewsArticle.List getData() {
        return getService().getNews(getStringMap());
    }
}