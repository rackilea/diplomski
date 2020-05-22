@Autowired
private MongoTemplate mongoTemplate;

DBObject query  = new BasicDBObject("field", "value");
DBCursor dbCursor = mongoTemplate.getCollection("collectionName").find(query); 

Iterator<DBObject> iterator = dbCursor.iterator();
while(iterator.hasNext()){
    Object value = iterator.next().get("otherfield");
}