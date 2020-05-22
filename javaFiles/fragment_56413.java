javax.jcr.query.QueryResult result = query.execute();
NodeIterator iter = result.getNodes();
while ( iter.hasNext() ) {
    Node node = iter.nextNode();
    // The 'jcr:created' property is mandatory (and autocreated), so 
    // in our case we don't have to check if the property exists
    // or handle a PathNotFoundException. And single-valued properties
    // always have a value.
    Value value = node.getProperty("jcr:created").getDate();
    int year = value.getDate().get(Calendar.YEAR);
    // do something with the year
}