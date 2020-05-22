BasicDBObject query = new BasicDBObject();

query.put("i", 71);
cur = coll.find(query);

while(cur.hasNext()) {
    System.out.println(cur.next());
}