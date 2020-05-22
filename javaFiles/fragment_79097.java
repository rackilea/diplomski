@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Book {
    @XmlAttribute
    private String author;
    @XmlID @XmlAttribute
    private String title; 
    @XmlElementRef
    private RESTServiceDiscovery rest;

    public Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}