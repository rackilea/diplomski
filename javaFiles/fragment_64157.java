import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.*;

@XmlRootElement(name="movie")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNamedObjectGraph(
        name="partial",
        attributeNodes={
            @XmlNamedAttributeNode("_id"),
            @XmlNamedAttributeNode(value="_director", subgraph="partial"),
            @XmlNamedAttributeNode(value="_actors", subgraph="partial")
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
public class MovieImpl implements Movie {

    @XmlElement(name="id")
    @Id
    @Column(name = "movieId", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int _id;

    @XmlElement(name="director", type=PersonImpl.class)
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PersonImpl.class)
    @JoinColumn(name = "directorId")
    Person _director;

    @XmlElementWrapper(name="actors")
    @XmlElement(name="actor", type=PersonImpl.class)
    @XmlInverseReference(mappedBy="_actors")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = PersonImpl.class)
    @JoinTable(name = "movie_has_actors", joinColumns = { @JoinColumn(name = "movieId", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "personId", nullable = false) })
    Collection<Person> _actors;

    public Collection<Person> getActors() {
        return _actors;
    }

}