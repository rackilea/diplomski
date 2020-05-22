List<DBObject> unwindItems = new ArrayList<>();

if(<item2 is not null>){ //pseudo code
  DBObject unwindItem1 = new BasicDBObject("$unwind", "$item1");
  unwindItems.add(unwindItem1);
}
if(<item2 is not null>){ //pseudo code
  DBObject unwindItem2 = new BasicDBObject("$unwind", "$item2");
  unwindItems.add(unwindItem2);
}
//add any other dbObject in the list, it need not be an unwind operation, it could be match, project, group etc.

DBObject command = new BasicDBObject("aggregate", "foo");
command.put("pipeline", dbObjects);