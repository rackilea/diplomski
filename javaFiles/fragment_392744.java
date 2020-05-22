import java.io.InputStream;
import java.io.OutputStream;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.RDFJsonLDDocumentFormat;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class Check {
    public static void main(String[] args) throws Exception {
        InputStream inputstream=null;
        OutputStream outputstream=null;
        OWLDocumentFormat ontologyFormat = new RDFJsonLDDocumentFormat();
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(inputstream);
        manager.saveOntology( ontology, ontologyFormat, outputstream );
    }
}