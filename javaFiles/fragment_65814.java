BasicDBList geoCoord = new BasicDBList();
    geoCoord.add(longitude);
    geoCoord.add(latitude);

    BasicDBList geoParams = new BasicDBList();
    geoParams.add(geoCoord);
    geoParams.add(10);

    BasicDBObject query = new BasicDBObject("loc", 
        new BasicDBObject("$geoWithin", 
            new BasicObject("$center", geoParams)
        )
    );