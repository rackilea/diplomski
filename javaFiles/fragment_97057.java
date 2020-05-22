import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "published")
    private Date datePublished;

    @XmlElement(name = "author")
    private Author author;

    public String toString(){
        return String.format("Id: %s, Title: %s, Author: %s, Published: %s",
               id,
               title,
               author.toString(),
               datePublished.toString());
        }

}