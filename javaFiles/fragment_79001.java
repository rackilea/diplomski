DBObject update = new BasicDBObject(
        "$setOnInsert", new BasicDBObject(
            "channel", 6
        )
    ).append(
        "$push", new BasicDBObject(
            "heardpoints", new BasicDBObject(
                "$each", new DBObject[]{
                    new BasicDBObject(
                        "geometry",
                        new BasicDBObject("type","Point").append(
                            "coordinates", new double[]{-75.234564, 36.12345}
                        )
                    ).append(
                        "time", new DateTime(2014,1,1,0,0,DateTimeZone.UTC).toDate()
                    )
                }
            ).append(
                "$sort", new BasicDBObject(
                    "time", -1
                )
            ).append("$slice", 20)
        )
    );