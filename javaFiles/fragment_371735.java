@Root(name = "channel", strict = false)
public class Channel {
    @ElementList(name = "item", inline = true)
    List<Article> articleList;
    @Element
    private String title;
    @Element
    private String link;
    @Element
    private String description;