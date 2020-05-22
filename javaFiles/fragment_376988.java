MongoURI uri = new MongoURI("mongodb://ip of server");
    Mongo mongo = (new Mongo.Holder()).connect(uri);
    DB db = mongo.getDB("placeDB");
    DBCollection coll = db.getCollection("places");
    DBCursor cursor = coll.find();
    JSONArray placeList = new JSONArray();
    String places = "";
    while (cursor.hasNext()) {
        places = cursor.next().get("placeList").toString();

    }
    String[] place = places.split(",");
    for (int i = 0; i < place.length; i++) {
        placeList.add(place[i]);
    }

    System.out.println(placeList);