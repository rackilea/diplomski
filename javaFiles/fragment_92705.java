import org.apache.jena.atlas.io.IndentedWriter;
import org.apache.log4j.Logger;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.RDF;

public class Jungle1 {
    public static final String jungle_file = "jungle.n3";
    public static final String NL = System.getProperty("line.separator");

    private static final Logger log = Logger.getLogger("Jungle1");

    public static void main(String[] args) {
        // create the simplest model there is
        //
        final Model m = ModelFactory.createDefaultModel();
        // use the file manager to read an RDF document into the model
        FileManager.get().readModel(m, jungle_file);
        log.debug("We have loaded a model with no. statements = " + m.size());
        final String jungle = "http://www.lirmm.fr/jungle#";
        final String prolog1 = "PREFIX jungle: <" + jungle + ">";
        final String prolog2 = "PREFIX rdf: <" + RDF.getURI() + ">";
        // Query string.
        final String queryString = prolog1 + NL + prolog2 + NL + "SELECT ?individu WHERE {?individu rdf:type jungle:Lion }";
        final Query query = QueryFactory.create(queryString);
        // Print with line numbers
        query.serialize(new IndentedWriter(System.out, true));
        System.out.println();
        // Create a single execution of this query, apply to a model
        // which is wrapped up as a Dataset
        final QueryExecution qexec = QueryExecutionFactory.create(query, m);
        // Or QueryExecutionFactory.create(queryString, model) ;
        System.out.println("Les Lions : ");
        try {
            // Assumption: it’s a SELECT query.
            final ResultSet rs = qexec.execSelect();
            // The order of results is undefined.
            for (; rs.hasNext();) {
                final QuerySolution rb = rs.nextSolution();
                // Get title - variable names do not include the ’?’
                final RDFNode y = rb.get("individu");
                System.out.print("uri : " + y + "--- ");
                final Resource z = rb.getResource("individu");
                System.out.println("plus simplement " + z.getLocalName());
            }
        } finally {
            // QueryExecution objects should be closed to free any system
            // resources
            qexec.close();
        }
    }
}