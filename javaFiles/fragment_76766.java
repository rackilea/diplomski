DBObject unwindParam = new BasicDBObject("$unwind","$dataItems");
    DBObject matchParam = new BasicDBObject("$match",
                                         new BasicDBObject("dataItems.version",
            new BasicDBObject("$gt",requestedModule.getVersion())));                                       
    DBObject fields = new BasicDBObject("dataItems", 1);
    DBObject projectParam = new BasicDBObject("$project", fields);
    AggregationOutput output = mongoTemplate.getCollection(
                                    "appModules").aggregate(
                                     unwindParam, matchParam,projectParam);
    CommandResult updatedData = output.getCommandResult();
    BasicDBList resList = (BasicDBList) updatedData.get("result");