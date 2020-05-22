public class JavaAggregation {
    public static void main(String args[]) throws UnknownHostException {

        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("test");

        DBCollection coll = db.getCollection("readings");

        // create the pipeline operations, first with the $match
        DBObject match = new BasicDBObject("$match",
                        new BasicDBObject("store_data.store_uuid", new BasicDBObject("$in", StoreIds))
                            .append("product_related_data.product_uuid", productId)                         
                    );

        // sort pipeline
        DBObject sort = new BasicDBObject("$sort",
                            new BasicDBObject("time.check_date", -1)
                        );

        // build the $group operations
        DBObject groupFields = new BasicDBObject( "_id", "$sensostrip_data.barcode"); // group by barcode
        groupFields.put("stock_percentage", new BasicDBObject( "$first", "$stock_related_data.stock_percentage")); // get the first when ordered documents are grouped
        groupFields.put("store_uuid", new BasicDBObject( "$first", "$store_data.store_uuid"));
        groupFields.put("check_date", new BasicDBObject( "$first", "$time.check_date"));
        // append any other necessary fields

        DBObject group = new BasicDBObject("$group", groupFields);

        // limit step
        DBObject limit = new BasicDBObject("$limit", 100);

        // put all together 
        List<DBObject> pipeline = Arrays.asList(match, sort, group, limit);

        AggregationOutput output = coll.aggregate(pipeline);

        for (DBObject result : output.results()) {
            System.out.println(result);
        }
    }
}