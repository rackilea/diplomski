OWLOntology o = ... your ontology here
    String ns = "http://localhost:3030/DigiWord.owl#";
    OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();
    OWLObjectProperty relatedto = df.getOWLObjectProperty(IRI.create(ns + "relatedTo"));
    OWLDataProperty stringValue = df.getOWLDataProperty(IRI.create(ns + "stringValue"));
    SimpleRenderer renderer = new SimpleRenderer();
    for (OWLNamedIndividual i : o.getIndividualsInSignature()) {
        for (OWLLiteral lit : EntitySearcher.getDataPropertyValues(i, stringValue, o)) {
            System.out.println(i + " has values " + renderer.render(lit));
        }
        for (OWLIndividual related : EntitySearcher.getObjectPropertyValues(i, relatedto, o)) {
            for (OWLLiteral lit : EntitySearcher.getDataPropertyValues(related, stringValue, o)) {
                System.out.println(i + " related to " + related + " which has values " + renderer.render(lit));
            }
        }
    }