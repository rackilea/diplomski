Relationship r = node1.createRelationshipTo(graphDb.getNodeById(idNode2), new RelationshipType() {
    @Override
    public String name() {
        return "CONECTED";
    }
});

r.setProperty("PropertyName", "PropertyValue");