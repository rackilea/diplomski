import javax.xml.bind.annotation.*;

@XmlRootElement
public class Precondition {

    private PreconditionQuery query;

    @XmlElementRefs({
        @XmlElementRef(name="and", type = CompoundAndPreconditionQuery.class),
        @XmlElementRef(name="or", type= CompoundOrPreconditionQuery.class),
        @XmlElementRef(name="query", type=SimplePreconditionQuery.class)
    })
    public PreconditionQuery getQuery() {
        return query;
    }

    public void setQuery(PreconditionQuery query) {
        this.query = query;
    }

}