BasicDBObject query = new BasicDBObect();
 BasicDBObject update = new BasicDBObject("$currentDate",
     new BasicDBObject("date", true)
 );

 example.update(query,update,true,false);