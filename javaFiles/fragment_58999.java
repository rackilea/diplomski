public static void main(String[] args) throws Exception {
    OntologyManager ontologyManager=KAON2Manager.newOntologyManager();
    DefaultOntologyResolver resolver=new DefaultOntologyResolver();
    resolver.registerReplacement("http://kaon2.semanticweb.org/example01","file:src/ex01/example01.xml");
    ontologyManager.setOntologyResolver(resolver);
    Ontology ontology=ontologyManager.openOntology("http://kaon2.semanticweb.org/example01",new HashMap<String,Object>());
    ...
}