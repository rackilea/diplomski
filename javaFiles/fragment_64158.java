import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.*;

@XmlRootElement(name="actor")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNamedObjectGraph(
        name="partial",
        attributeNodes={
            @XmlNamedAttributeNode("_id"),
            @XmlNamedAttributeNode("_name"),
            @XmlNamedAttributeNode(value="_movies", subgraph="partial")
        },
        subgraphs={
            @XmlNamedSubgraph(
                name="location",
                attributeNodes = {
                    @XmlNamedAttributeNode("_id"),
                    @XmlNamedAttributeNode("_name")
                }
            )
        }
    )
@Entity
public class PersonImpl implements Person {

    @XmlElement(name="id")
    private int _id;

    @XmlElement(name="name")
    private String _name;

    @XmlElementWrapper(name="movies")
    @XmlElement(name="movie", type=MovieImpl.class)
    @XmlInverseReference(mappedBy="_actors")
    @ManyToMany(mappedBy = "_actors", targetEntity = MovieImpl.class)
    private Collection<Movie> _movies;

}