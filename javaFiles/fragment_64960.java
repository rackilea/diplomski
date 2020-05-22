DB db = mongoClient.getDB("test");
    DBCollection coll = db.getCollection("restaurants");

    BasicDBObject query = new BasicDBObject();

    query.put("cuisine", "Chinese");

    DBCursor cursor = coll.find(query);

    //coordinates for box of defined range around my location.
    double lat1 = myPoint.closestPoints(1)[0];
    double lat2 = myPoint.closestPoints(1)[1];
    double lon1 = myPoint.closestPoints(1)[2];
    double lon2 = myPoint.closestPoints(1)[3];

    try {

        while(cursor.hasNext()) {

        BasicBSONObject addressObj = (BasicBSONObject) cursor.next().get("address");
        BasicDBList addressList = (BasicDBList) addressObj.get("coord");

         double restLongitude  = (double) addressList.get(0);
         double restLatitude = (double) addressList.get(1);

        if ((restLatitude < lat2 && restLatitude > lat1) && (restLongitude < lon2 && restLongitude > lon1)) {
          System.out.println(restLatitude + "," + restLongitude + " box LAT is " + lat1 + ", " + lat2 + " box LON is " + lon1 + "," + lon2 );
        }

    }
    } catch (NullPointerException e) {

        System.err.println("NullPointerException: " + e.getMessage());

    } finally {
      cursor.close();
    }

 mongoClient.close();