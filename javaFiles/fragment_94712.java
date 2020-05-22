String buildingNum = "01";
    String floorNum = "1";
    String roomNum = "A";

    Bson filter = Filters.eq("building_number", buildingNum);
    String key = "floor_" + floorNum + ".room" + roomNum + ".occupant";
    Document update = new Document("$set", new Document(key, "occupied"));
    UpdateOptions options = new UpdateOptions().upsert(false);
    UpdateResult updateResult = coll.updateOne(filter, update, options); // change to many if required

    System.out.println(updateResult.getMatchedCount() + " " + updateResult.getModifiedCount() + " " + updateResult.getUpsertedId());