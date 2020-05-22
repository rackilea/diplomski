@XmlRootElement
public class Book {

    @XmlAttribute
    private String author;

    @XmlAttribute
    private String title;

    public Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}