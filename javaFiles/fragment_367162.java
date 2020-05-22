import javax.xml.bind.annotation.*;

@XmlRootElement(name = "query")
public class SimplePreconditionQuery extends PreconditionQuery {

    private String query;

    @XmlValue
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}