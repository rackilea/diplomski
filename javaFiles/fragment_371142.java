MongoCollection<Document> collection = mongodb.getCollection("PropertiesMQ");
    BasicDBObject filter = new BasicDBObject();
    filter.put("NOMBRE_HOST", host);
    filter.put("BASEDATOS.SID", sid);
    BasicDBObject data = new BasicDBObject();
    data.put("BASEDATOS.$.IsContingenciaBD", state);
    BasicDBObject command = new BasicDBObject();
    command.put("$set", data);
    System.out.println(filter + ", " + command);
    collection.updateOne(filter, command); //Use Command instead of data