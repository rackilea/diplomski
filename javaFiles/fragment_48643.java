import javax.xml.bind.annotation.*;

public class Commodity {

    private String id;

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}