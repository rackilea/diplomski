import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;

public class AddTypesExample {
    public static void main(String[] args) {
        final String NS = "http://stackoverflow.com/q/20222080/1281433/";
        final Model model = ModelFactory.createDefaultModel();

        final Resource classA = model.createResource( NS+"A" );
        final Resource classB = model.createResource( NS+"B" );
        final Resource classC = model.createResource( NS+"C" );
        final Resource classD = model.createResource( NS+"D" );

        // You can create a resource with a specified type.
        final Resource x = model.createResource( NS+"x", classA );

        // And subsequent calls to createResource will add more types.
        model.createResource( NS+"x", classB );

        // You could also add the type to the resource
        x.addProperty( RDF.type, classC );

        // Or add the statement to the model
        model.add( x, RDF.type, classD );

        model.write( System.out, "RDF/XML" );
    }
}