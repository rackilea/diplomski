@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "nitexp", namespace="http://www.nitml.org/nitexp/1.0")
public class Article {

    @XmlElement(name = "item", namespace="http://www.nitml.org/nitexp/1.0")
    private ArticleItem  item;

}