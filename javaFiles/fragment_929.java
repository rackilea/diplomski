Set<OWLLogicalAxiom> axiomSet=localOntology.getLogicalAxioms();
    Iterator<OWLLogicalAxiom> iteratorAxiom= axiomSet.iterator();

    while(iteratorAxiom.hasNext()) {
        OWLAxiom tempAx= iteratorAxiom.next();
        if(!tempAx.getIndividualsInSignature().isEmpty()){
            System.out.println(tempAx.getIndividualsInSignature());
            System.out.println(tempAx.getDataPropertiesInSignature());
            System.out.println(tempAx.getObjectPropertiesInSignature());
        }
    }