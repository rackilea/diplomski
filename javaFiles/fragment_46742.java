package forum11537931;

import java.util.*;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

public class RelationsAdapter extends XmlAdapter<RelationsAdapter.AdaptedRelations, Relations> {

    @Override
    public Relations unmarshal(AdaptedRelations v) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AdaptedRelations marshal(Relations relations) throws Exception {
        AdaptedRelations adaptedRelations = new AdaptedRelations();
        for(Relation relation : relations.relations) {
            adaptedRelations.relations.add(new JAXBElement<Relation>(new QName(relations.targetType), Relation.class, relation));
        }
        return adaptedRelations;
    }

    @XmlSeeAlso({Registry.class})
    public static class AdaptedRelations {

        @XmlElementRef(type=JAXBElement.class, name="artist")
        public List<JAXBElement<Relation>> relations = new ArrayList<JAXBElement<Relation>>();

    }

}