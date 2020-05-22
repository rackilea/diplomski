DBObject query = QueryBuilder.start("email").is(email).get();
DBCursor cursor = users.find(query);

while (cursor.hasNext()) {

   DBObject user = cursor.next();
   String firstName = (String)user.get("first_name");
   String lastName = (String)user.get("last_name");

   //TODO: use extracted properties to build User object   
}