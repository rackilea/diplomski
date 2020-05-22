// BasicDBObject match = null; // wrong!
BasicDBObject match = new BasicDBObject("$match", new BasicDBObject()); // correct!
if (organizationId != null) {
    match.append("organizationId", organizationId);
}
if (optionalParams != null) {
    Date fromDate = (Date) optionalParams.get("fromDate");
    Date toDate = (Date) optionalParams.get("toDate");
    match.append("requestDate", new BasicDBObject("$gte", fromDate)
        .append("$lte", toDate));
}