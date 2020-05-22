private void performOperation() {
    MongoClient mongo = new MongoClient("localhost", 27017);
    MongoClient mongoClient = new MongoClient();
    DB db = mongoClient.getDB("test");
    DBCollection table = db.getCollection("vinay");

    logger.info("connected successfully");

    BasicDBObject searchQuery = new BasicDBObject();

    List<BasicDBObject> andQuery = new ArrayList<BasicDBObject>();
    andQuery.add(new BasicDBObject("email", "technotest91@gmail.com"));
    andQuery.add(new BasicDBObject("tempDetails.tempEmail", "abc@gmail.com"));

    searchQuery.put("$and", andQuery);

    logger.info("executing :"+ searchQuery);

    DBCursor cursor = table.find(searchQuery);
    if (cursor.count() != 0) {
        while (cursor.hasNext()) {

            BasicDBList jobStatusList = (BasicDBList) cursor.next().get("tempDetails");

            for (int k = 0; k < jobStatusList.size(); k++) {
                BasicDBObject tempJobObject = (BasicDBObject) jobStatusList.get(k);

                BasicDBList hiredDatesList = (BasicDBList) tempJobObject.get("hiredDates");

                for (int i = 0; i < hiredDatesList.size(); i++) {
                    BasicDBObject hiredDatesObject = (BasicDBObject) hiredDatesList.get(i);
                    String dbBookingId = hiredDatesObject.getString("bookingId");

                    if (dbBookingId.equalsIgnoreCase("36Y0YM")) {
                        BasicDBObject doc = new BasicDBObject("$set", new BasicDBObject()
                                .append("tempDetails." + k + ".hiredDates." + i + ".status", "New Status"));

                        table.update(searchQuery, doc, false, false);

                        logger.info(doc);

                    } else {
                        logger.info("no record find");
                    }
                }
            }
        }
    }
}