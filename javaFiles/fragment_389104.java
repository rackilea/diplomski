import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class RetrieveRemoteRDF {
    public static void main(String[] args) {
        final String url = "http://www.w3.org/TR/REC-rdf-syntax/example14.nt";
        final Model model = ModelFactory.createDefaultModel();
        model.read(url);
        model.write(System.out);
    }
}