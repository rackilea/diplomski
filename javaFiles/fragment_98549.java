import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class IMDBInfo {

    @XmlElement
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }
}