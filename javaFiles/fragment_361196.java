Aggregation aggregation = newAggregation(
        project("y","x"),
        sort(Sort.Direction.ASC,"x"),
        unwind("y"),
        match(criteria),
        limit(maxElements),
        skip(elementsToSkip)
    );

    BasicDBObject context =
       (BasicDBObject)aggregation.toDbObject("collection",DEFAULT_CONTEXT);
    context.append("allowDiskUse",true);
    System.out.println(context);

    CommandResult commandResult = mongoOperation.executeCommand(context);
    System.out.println(commandResult);