DBObject unwindEntities = new BasicDBObject("$unwind","$Entities");

     DBObject groupSameIdEntities = new BasicDBObject("_id","$_id");
     groupSameIdEntities.put("Date", new BasicDBObject("$first","$Date"));
     groupSameIdEntities.put("Topics", new BasicDBObject("$first","$Topics"));
     groupSameIdEntities.put("EntitiesSum", 
                    new BasicDBObject("$sum","$Entities.Sentiment.Value"));


     DBObject unwindTopics = new BasicDBObject("$unwind","$Topics");

     DBObject groupSameIdTopics = new BasicDBObject("_id","$_id");
     groupSameIdTopics.put("Date", new BasicDBObject("$first","$Date"));
     groupSameIdTopics.put("EntitiesSum", 
                         new BasicDBObject("$first","$EntitiesSum"));
     groupSameIdTopics.put("TopicsSum",
                        new BasicDBObject("$sum","$Topics.Sentiment.Value"));

     DBObject project = new BasicDBObject("_id",0);
     project.put("Date",1);
     project.put("EntitiesSum",1);
     project.put("TopicsSum",1);
     project.put("netSumPerId",
             new BasicDBObject("$add",
                   new String[]{"$EntitiesSum","$TopicsSum"}));

     DBObject groupByDate = new BasicDBObject("_id","$Date");
     groupByDate.put("EntitiesSentimentSum", 
                     new BasicDBObject("$sum","$EntitiesSum"));
     groupByDate.put("TopicsSentimentSum", 
                     new BasicDBObject("$sum","$TopicsSum"));
     groupByDate.put("netSentimentSum", 
                      new BasicDBObject("$sum","$netSumPerId"));

     AggregationOutput output = col.aggregate(unwindEntities,
                                new BasicDBObject("$group",
                                             groupSameIdEntities),
                                unwindTopics,
                                new BasicDBObject("$group",groupSameIdTopics),
                                new BasicDBObject("$project",project),
                                new BasicDBObject("$group",groupByDate));