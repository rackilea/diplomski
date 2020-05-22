// get collection
    DBCollection collection = ds.getCollection("collection");

    // Arguments
    BasicDBList myargs = new BasicDBList();
    myargs.add(new Integer(32008));
    myargs.add(new Integer(11989));

    // $match phase
    BasicDBObject match = new BasicDBObject("$match",
        new BasicDBObject("g",
            new BasicDBObject("$in", myargs)
        )
    );

    // $group phase
    BasicDBObject group = new BasicDBObject("$group",
        new BasicDBObject("_id",
            new BasicDBObject("agnt_id","$agnt_id")
                .append("g", "$g")
        )
    );

    // pipeline
    BasicDBList pipeline = new BasicDBList();
    pipeline.add(match);
    pipeline.add(group);

    // Aggregate
    AggregationOutput output =  collection.aggregate(pipeline);