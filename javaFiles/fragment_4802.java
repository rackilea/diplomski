BasicDBObject query = new BasicDBObject();  // MongoDB query
BasicDBObject record = new BasicDBObject(); // MongoDB record
BasicDBObject dbObject = new BasicDBObject(); // fieldsToUpdate

query.put("comments.cid","17426944");
dbObject.put("comments.$.newField","something");
record.put("$set",dbObject );
mongoCtrl.updateCollection(query, record, false, true);