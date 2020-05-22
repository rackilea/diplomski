BasicDBObject whereQuery = new BasicDBObject();
whereQuery.put("apiKey", "1eb9b9e3-3af1-4b25-b7ea-1f2fcb1d9af6");

BasicDBObject fields = new BasicDBObject();
fields.put("apiParamDesc", 1);
fields.put("_id", 0);

DBCursor cursor = table.find(whereQuery, fields);
while(cursor.hasNext()) {
    System.out.println(cursor.next());
}