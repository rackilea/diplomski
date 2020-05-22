javax.jcr.query.QueryResult result = query.execute();
RowIterator iter = result.getRows();
while ( iter.hasNext() ) {
    Row row = iter.nextRow();
    Value value = row.getValue("dateField");
    // Our query won't return a null, since `jcr:created' is mandatory
    // and autocreated on `mix:created`, so we don't have to check 
    // value for null. Other properties, however, may not be mandatory
    // so you might need to check null for other queries ...
    int year = value.getDate().get(Calendar.YEAR);
    // do something with the year
}