import org.bson.Document; 

AggregationPipeline pipCount = datastore.createAggregation(MyTable.class)
            .match(query1)
            .match(query2)
            .unwind("somethingID")
            .match(query3)
            .group("_id", grouping("count", new Accumulator("$sum", 1)))
            .project(Projection.projection("count"));

    Iterator<Document> result = pipCount.aggregate(Document.class);

    while (result.hasNext()) {
        Document document = result.next();
        Integer count = document.getInteger("count");
    }