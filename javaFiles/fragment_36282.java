import java.io.FileWriter;
import java.io.InputStream;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDF;

public class Mgt {

    public static void main(String[] args) throws Exception {
        String namespace = "http://www.semanticweb.org/Word#";
        String file = "word.owl";
        OntModel jenaModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF);

        InputStream in = FileManager.get().open(file);
        jenaModel.read(in, null);
        OntClass Noun = jenaModel.getOntClass(namespace + "Noun");
        Individual Organization = Noun.createIndividual(namespace + "Organization");
        jenaModel.add(Organization, RDF.type, Noun);
        FileWriter out = new FileWriter("word.out.owl");
        jenaModel.getWriter("RDF/XML-ABBREV").write(jenaModel, out, namespace);
        out.close();
    }
}