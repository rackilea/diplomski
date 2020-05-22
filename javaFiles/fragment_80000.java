List cond = new ArrayList();
cond.add(new Document("$eq", Arrays.asList("$idcard.status", "normal")));
cond.add(0);
cond.add(1);

AggregateIterable<Document> aggregate = dbCollection.aggregate(Arrays.asList(
        group("$company_id",
                sum("count", new Document("$cond", cond))
        )));