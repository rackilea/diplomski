OrientGraphFactory ogf = new OrientGraphFactory(
        "plocal:/home/paulkalkbrenner/Dokumente/odb/databases/ConnectER", "admin", "admin");
    OrientGraph og = ogf.getTx();

    OClass cl=og.createVertexType("Person", "V");
    cl.createProperty("LastName", OType.STRING);

    OrientVertex v1=og.addVertex("class:Person");
    v1.setProperties("Lastname","Alessandro");

    for (Vertex v : og.getVertices()) {
        System.out.println(v.getProperty("Lastname"));
    }

    og.shutdown();