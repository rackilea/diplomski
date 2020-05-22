package forum11537931;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class Registry {
    private static final String ARTIST = "artist";
    private static final String FOO = "foo";

    @XmlElementDecl(name=ARTIST)
    public JAXBElement<Relation> createArtist(Relation relation) {
        return new JAXBElement<Relation>(new QName(ARTIST), Relation.class, relation);
    }

    @XmlElementDecl(name=FOO, substitutionHeadName=ARTIST)
    public JAXBElement<Relation> createFoo(Relation relation) {
        return new JAXBElement<Relation>(new QName(FOO), Relation.class, relation);
    }

}