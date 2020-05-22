public static void main(String ... args) {
    Model model = ModelFactory.createDefaultModel();
    model.setNsPrefix("rdf", RDF.getURI());
    model.setNsPrefix("ex", "http://example.org/demo#");
    model.setNsPrefix("sp", SP.getURI());
    model.setNsPrefix("rdfs", RDFS.getURI());

    String query = "SELECT ?person\n" +
                    "WHERE {\n" +
                    "    ?person a ex:Person .\n" +
                    "    ?person ex:age ?age .\n" +
                    "    FILTER (?age > 18) .\n" +
                    "}";
    Query arqQuery = ARQFactory.get().createQuery(model, query);
    ARQ2SPIN arq2SPIN = new ARQ2SPIN(model);
    Select select1 = (Select) arq2SPIN.createQuery(arqQuery, null);
    select1.addProperty(RDFS.comment, "Comment1"); // <-- as part of rdf

    Resource anon = model.createResource();
    anon.addProperty(RDF.type, SP.Select);
    anon.addProperty(SP.text, model.createTypedLiteral(
            "# Comment2\n" + // <-- as part of string
            "SELECT ?person\n" +
            "WHERE {\n" +
            "    ?person a ex:Person .\n" +
            "    ?person ex:age ?age .\n" +
            "    FILTER (?age < 22) .\n" +
            "}"));
    Select select2 = anon.as(Select.class);
    System.out.println("========================");
    model.write(System.out, "ttl");
    System.out.println("========================");
    System.out.println("Select1:\n" + select1);
    System.out.println("Select2:\n" + select2);
}