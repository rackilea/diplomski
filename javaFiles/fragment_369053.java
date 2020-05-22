private static Logger logger = LoggerFactory
        .getLogger(owl.api.test.StandaloneOWLNamedIndividualRetrievalv5.AppHardwareTest.class);
// Why This Failure marker
private static final Marker WTF_MARKER = MarkerFactory.getMarker("WTF");

static OWLReasoner reasoner;

static void printChildren(NodeSet<OWLClass> owlClasses) {
    for (Node<OWLClass> node : owlClasses) {
        logger.trace(node.getRepresentativeElement().toString());
        if (!node.getRepresentativeElement().isBottomEntity())
            printChildren(reasoner.getSubClasses(node.getRepresentativeElement()));
    }       
}

public static void main(String[] args) {
    try {
        // Setup physical IRI for storing ontology
        Path path = Paths.get(".").toAbsolutePath().normalize();
        IRI loadDocumentIRI = IRI.create("file:" + path.toFile().getAbsolutePath() + "/hardware.owl");
        IRI saveDocumentIRI = IRI.create("file:" + path.toFile().getAbsolutePath() + "/hardwareSave.txt");

        // Initialize
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(loadDocumentIRI);

        // Write to JsonLD format
        OWLDocumentFormat ontologyFormat = new RDFJsonLDDocumentFormat();
        manager.saveOntology(ontology, ontologyFormat, saveDocumentIRI);        

        // Print tree structure
        OWLReasonerFactory reasonerFactory = new JFactFactory();
        reasoner = reasonerFactory.createReasoner(ontology);            
        Node<OWLClass> top = reasoner.getTopClassNode();
        logger.trace(top.getRepresentativeElement().toString());
        printChildren(reasoner.getSubClasses(top.getRepresentativeElement()));          
    } catch (Throwable t) {
        logger.error(WTF_MARKER, t.getMessage(), t);
    }
}