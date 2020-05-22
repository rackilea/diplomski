for (OWLNamedIndividual i : o.getIndividualsInSignature()) {
        for (OWLIndividual related : EntitySearcher.getObjectPropertyValues(i, relatedto, o)) {
            for (OWLLiteral lit : EntitySearcher.getDataPropertyValues(related, stringValue, o)) {
                if(lit.getLexicalForm().equals("1")){
                    for (OWLLiteral lit : EntitySearcher.getDataPropertyValues(i, stringValue, o)) {
                        System.out.println(i + " has values " + renderer.render(lit));
                    }
                }
            }
        }
    }