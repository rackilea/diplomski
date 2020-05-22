DBObject query = new BasicDBObject();
DBCursor cursor3 = null;
DBObject dbObject = null;
while(cursor2.hasNext()){ //display all fast food restaurants
    dbObject = cursor2.next();
    query.put("business_id",dbObject.get("business_id"))//get the business_id from dbObject returned from above
    cursor3 = table2.find(query); // here you have all the reviews for that business.
    //next loop through cursor3 for your reviews
}