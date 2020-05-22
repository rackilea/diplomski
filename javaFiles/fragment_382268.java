dataStream.map( message -> {
    return (ParseResult) Neo4JMessageParser.parse(message);
}).foreachRDD( rdd -> {
    List<ParseResult> parseResults = rdd.collect();
    String cypherQuery = Neo4JMessageParser.buildQuery(parseResults);
    Neo4JRepository.update(cypherQuery);
    // commit offsets
});