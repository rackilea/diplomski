WriteResult wr = getMongoTemplate().updateMulti(
  new Query(where("rates.rateCardId").is(1234)),
  new Update().set("rates.$[item].rate", 200),
  new UpdateOptions()
    .arrayFilters(
      Arrays.asList( Filters.in("item.rateCardId",Arrays.asList(1,2)) )
    ), 
  ProductRates.class
);