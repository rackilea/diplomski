@Service
public class NewsResourceAssembler implements ResourceAssembler<News, Resource<NewsResource>> {

    private EntityLinks entityLinks;

    @Autowired
    public void setEntityLinks(EntityLinks entityLinks) {
        this.entityLinks = entityLinks;
    }

    @Override
    public Resource<NewsResource> toResource(News news) {

        Link self = entityLinks.linkFor(News.class).slash(news.getId()).withSelfRel();
        Link newsTags = entityLinks.linkFor(News.class).slash(news.getId()).slash("newsTags").withRel("newsTags");
        Link newsComments = entityLinks.linkFor(News.class).slash(news.getId()).slash("newsComments").withRel("newsComments");

        final NewsResource newsResource = new NewsResource();
        //set any fields to which do you wants to send client
        //newsResource.setExampleFields();
        //newsResource.setNewsTagList(news.getNewsTag()); //example code. Change according to your models

        return new Resource(newsResource, self, newsTags, newsComments);
    }
}