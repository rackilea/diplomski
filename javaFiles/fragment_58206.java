@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "item", namespace="http://www.nitml.org/nitexp/1.0")
public class ArticleItem {

    @XmlAttribute
    private String type;

    @XmlElement(name = "nd", namespace="http://www.nitml.org/nitexp/1.0")
    private String nitoid;

    @XmlElement(name = "title", namespace="http://www.nitml.org/nitexp/1.0")
    private String title;

    @XmlElement(name = "author", namespace="http://www.nitml.org/nitexp/1.0")
    private String author;

}