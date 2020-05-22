import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "and")
public class CompoundAndPreconditionQuery extends PreconditionQuery {

    private Collection<PreconditionQuery> preconditionQueries = new ArrayList();

    @XmlElementRefs({
            @XmlElementRef(name="and", type = CompoundAndPreconditionQuery.class),
            @XmlElementRef(name="or", type= CompoundOrPreconditionQuery.class),
            @XmlElementRef(name="query", type=SimplePreconditionQuery.class)
    })
    public Collection<PreconditionQuery> getPreconditionQueries() {
        return preconditionQueries;
    }

    public void setPreconditionQueries(Collection<PreconditionQuery> preconditionQueries) {
        this.preconditionQueries = preconditionQueries;
    }

}