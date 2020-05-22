public class JavaAggregation {
    public static void main(String args[]) throws UnknownHostException {

        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("test");

        DBCollection coll = db.getCollection("employee");

        // create the pipeline operations, first with the $match
        DBObject match = new BasicDBObject("$match",
            new BasicDBObject("_id", employeeId)
        );

        // build the $lookup operations
        DBObject lookupFields = new BasicDBObject("from", "company");
        lookupFields.put("localField", "companyId");
        lookupFields.put("foreignField", "_id");
        lookupFields.put("as", "company");      
        DBObject lookup = new BasicDBObject("$lookup", lookupFields);

        // build the $project operations
        DBObject projectFields = new BasicDBObject("name", 1);
        projectFields.put("lastName", 1);
        projectFields.put("companyId", 1);
        projectFields.put("companyName", "$company.companyName");       
        DBObject project = new BasicDBObject("$project", projectFields);

        List<DBObject> pipeline = Arrays.asList(match, lookup, project);

        AggregationOutput output = coll.aggregate(pipeline);

        for (DBObject result : output.results()) {
            System.out.println(result);
        }
    }
}