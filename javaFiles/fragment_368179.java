private static void orientDBCollections() throws IOException {
    dropDBIfExists(URL, USER);
    createDBIfDoesNotExist(URL, USER);

    OPartitionedDatabasePool pool = new OPartitionedDatabasePool(URL, USER, USER);
    try (ODatabaseDocument db = pool.acquire()) {
        OSchema schema = db.getMetadata().getSchema();
        OClass classA = schema.createClass("A");
        OClass classB = schema.createClass("B");
        classA.createProperty("embMap", OType.EMBEDDEDMAP, classB);
        classA.createProperty("linkMap", OType.LINKMAP, classB);
        classA.createProperty("embSet", OType.EMBEDDEDSET, classB);
        classA.createProperty("linkSet", OType.LINKSET, classB);

        ODocument docA = new ODocument("A");
        ODocument docB = new ODocument("B");
        docB.field("name", "nanana");

        Map<String, ODocument> map = new HashMap();
        map.put("thekey", docB);
        docA.field("embMap", map, OType.EMBEDDEDMAP);
        docA.field("linkMap", map, OType.LINKMAP);

        Set<ODocument> set = new HashSet();
        set.add(docB);
        docA.field("embSet", set, OType.EMBEDDEDSET);
        docA.field("linkSet", set, OType.LINKSET);

        docA.save();
    } finally {
        pool.close();
    }
}