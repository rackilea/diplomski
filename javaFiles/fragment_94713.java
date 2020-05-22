DBCollection coll = db.getCollection("Facilities");
    String buildingNum = (String) buildingBox.getValue();
    String floorNum = (String) floorBox.getValue();
    String roomNum = (String) roomBox.getValue();
    String key = "floor_" + floorNum + ".room" + roomNum + ".occupant";
    BasicDBObject docFilter = new BasicDBObject("building_number", buildingNum);
    BasicDBObject docUpdate = new BasicDBObject("$set",
            new BasicDBObject(key, "occupied"));
    WriteResult updateResult = coll.update(docFilter, docUpdate);