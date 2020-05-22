OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
    OWLOntology pizzaOntology = manager.loadOntologyFromOntologyDocument(f);
    Set<OWLOntology> allOntologies = manager.getImportsClosure(pizzaOntology);
    // System.out.println(allOntologies);
    OWLReasonerFactory reasonerFactory = new ElkReasonerFactory();
    OWLReasoner reasoner = reasonerFactory.createReasoner(pizzaOntology);
    // pizzaOntology
    OWLDataFactory factory = manager.getOWLDataFactory();
    Map<OWLAnnotationSubject, String> allLabels = new HashMap<>();
    Map<OWLAnnotationSubject, String> allExactSynonyms = new HashMap<>();
    for (OWLAnnotationAssertionAxiom ax : pizzaOntology
        .getAxioms(AxiomType.ANNOTATION_ASSERTION)) {
        // Check if the axiom is a label and write to file
        OWLAnnotationSubject subject = ax.getSubject();
        if (ax.getProperty().toString().contains("hasExactSynonym")) {
            allExactSynonyms.put(subject, ax.getValue().toString());
        }
        if (ax.getProperty().equals(factory.getRDFSLabel())) {
            String label = ax.getValue().toString();
            label = label.toLowerCase();
            label = label.replaceAll("[^\\p{L}\\p{Nd}]+", " ");
            allLabels.put(subject, label);
        }
    }