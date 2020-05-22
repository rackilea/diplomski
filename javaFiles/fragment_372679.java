BasicDBObject update = new BasicDBObject();
BasicDBObject stamps = new BasicDBObject();
stamps.append("currentVisit", "1377500985").append("lastVisit", "1377500985");
BasicDBObject visits = new BasicDBObject();
update.append("$setOnInsert", stamps).append("$push", visits);

collection.update(doc, update, true);