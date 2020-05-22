public void splitModels() throws IOException {
    // First, create a model and read the content 
    // into it.  You probably already have this part, 
    // but we need it for a working example.
    Model model = ModelFactory.createDefaultModel();
    try (InputStream in = SplitModelExample.class.getResourceAsStream("/example.rdf")) {
        RDFDataMgr.read(model, in, Lang.RDFXML);
    }

    // List the subjects in the model.
    ResIterator subjects = model.listSubjects();

    // For each subject, create another empty model that will 
    // contain the triples of which the subject is the subject.
    // The #listProperties() method returns a StmtIterator over
    // those triples, and Model#add(StmtIterator) adds all the
    // triples to a model.  Then we'll print out each submodel
    // to make sure we're getting what we expect.
    while (subjects.hasNext()) {
        Resource subject = subjects.next();
        Model subModel = ModelFactory.createDefaultModel();
        subModel.add(subject.listProperties());

        System.out.println("\n<!-- Submodel for "+subject+". -->");
        RDFDataMgr.write(System.out, subModel, Lang.RDFXML);
    }
}