final Query query = new Query(new Criteria().andOperator(
        Criteria.where("_id").is("id"),
        Criteria.where("listA").elemMatch(Criteria.where("_id").is("id"))
));

final Update update = new Update().addToSet("listA.$.listB", stuff).set("listA.$.thing", "thing");

final WriteResult wr = mongoOperations.updateFirst(query, update, "collectionName");