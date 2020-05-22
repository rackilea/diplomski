import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.OWL2;

public class QualifiedRestrictionExample {
    public static OntClass createCardinalityQRestriction(
            OntModel model,
            String uri,
            Property prop,
            int cardinality, 
            OntClass clas ) {
        OntClass klass = model.createCardinalityRestriction( uri, prop, cardinality );
        klass.removeAll( OWL.cardinality );
        klass.addLiteral( OWL2.qualifiedCardinality, cardinality );
        klass.addProperty( OWL2.onClass, clas );
        return klass;
    }

    public static void main(String[] args) {
        String NS = "https://stackoverflow.com/q/20562107/1281433/";
        OntModel model = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM );
        OntClass test = model.createClass( NS+"Test" );
        OntProperty j = model.createObjectProperty( NS+"JeVysledkom" );
        OntClass k = model.createClass( NS+"Kolik_Fazovy" );
        OntClass x = createCardinalityQRestriction(model, null, j, 1, k);
        test.addSuperClass( x );
        model.write( System.out, "RDF/XML-ABBREV" );
    }
}