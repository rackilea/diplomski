import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDFS;

public class AddTypesExample {
    final private static String NS = "http://stackoverflow.com/q/20222080/1281433/";

    public static void main( String[] args ) {
        subclassModel().write( System.out, "RDF/XML" );
        System.out.println();
        subclassOntModel().write( System.out, "RDF/XML" );
    }

    public static Model subclassModel() {
        final Model model = ModelFactory.createDefaultModel();
        final Resource classA = model.createResource( NS+"A" );
        final Resource classB = model.createResource( NS+"B" );
        final Resource classC = model.createResource( NS+"C" );
        classB.addProperty( RDFS.subClassOf, classA );
        model.add( classC, RDFS.subClassOf, classA );
        return model;
    }

    public static OntModel subclassOntModel() { 
        final OntModel model = ModelFactory.createOntologyModel( OntModelSpec.RDFS_MEM );
        final OntClass a = model.createClass( NS+"A" );
        final OntClass b = model.createClass( NS+"B" );
        final OntClass c = model.createClass( NS+"C" );
        a.addSubClass( b );
        c.addSuperClass( a );
        return model;
    }
}