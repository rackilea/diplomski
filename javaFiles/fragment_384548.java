PrefixManager pm= new DefaultPrefixManager("http://www.co-ode.org/ontologies/pizza/pizza.owl#");
    OWLClass american=factory.getOWLClass("American", pm);
    Set<OWLClassAxiom> tempAx=localOntology.getAxioms(american);
    for(OWLClassAxiom ax: tempAx){
        for(OWLClassExpression nce:ax.getNestedClassExpressions())
            if(nce.getClassExpressionType()!=ClassExpressionType.OWL_CLASS)
                System.out.println(ax);
    }