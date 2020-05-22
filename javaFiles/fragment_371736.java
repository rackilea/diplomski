@Root(name = "item", strict = false)
public class Article {
    @Element
    private String title;
    @Element
    private String description;
    @Element
    private String link;
    @Element(required = false)
    private String author;
    @Element(required = false)
    private String pubDate;