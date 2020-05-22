BsonArray cond = new BsonArray();
BsonArray eq = new BsonArray();
eq.add(new BsonString("$idcard.status"));
eq.add(new BsonString("normal"));
cond.add(new BsonDocument("$eq", eq));
cond.add(new BsonInt64(0));
cond.add(new BsonInt64(1));

AggregateIterable<BsonDocument> aggregate = dbCollection.aggregate(Arrays.asList(
        group("$company_id",
                sum("count", new BsonDocument("$cond", cond))
    )));