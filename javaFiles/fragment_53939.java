import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;
import com.fasterxml.jackson.xml.annotate.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Site")
public class SiteData {

    private String id;

    private String affiliations;

    private String status;

    private String color;

    private String updateTime;

    private String name;

    private String subject;

    @JacksonXmlProperty(localName = "location")
    private LocationData location;

    public String getId() {
        return id;
    }

    public void setIdValue(String id) {
        this.id = id;
    }

    public String getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(String affiliations) {
        this.affiliations = affiliations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocationData getLocation() {
        return location;
    }

    public void setLocation(LocationData location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Site [id=" + id + ", affiliations=" + affiliations
                + ", status=" + status + ", color=" + color + ", updateTime="
                + updateTime + ", name=" + name + ", subject=" + subject
                + ", locations=" + location + "]";
    }
}