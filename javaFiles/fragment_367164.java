import javax.xml.bind.annotation.*;

@XmlSeeAlso({SimplePreconditionQuery.class, CompoundAndPreconditionQuery.class, CompoundOrPreconditionQuery.class})
@XmlTransient
public abstract class PreconditionQuery {
    // JAXB does not deal with interfaces by default >:(
}