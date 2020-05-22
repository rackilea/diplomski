while (results.hasNext()) {
    QuerySolution querySolution = results.next();
    RDFNode node = querySolution.get("n");
    String name = node.asLiteral().getString();
    System.out.println(name);
}