Resource ENTITY_TYPE = model.getResource("http://www.test.com/testModel.owl#Entity");
StmtIterator iter = model.listStatements(null, RDF.type, ENTITY_TYPE);
while (iter.hasNext()) {
    String entityID = iter.next().getSubject().getURI();
    System.out.println(entityID);
}