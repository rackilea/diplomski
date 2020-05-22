package forum11620825;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookType", propOrder = {"author"})
public class BookType {

    @XmlElement(required = true)
    protected String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String value) {
        this.author = value;
    }

}