Document groupFields = new Document();
 groupFields.append("linestatus", "$lineitems.linestatus");
 groupFields.append("returnflag", "$lineitems.returnflag");

 Document subtractDisc = new Document("$subtract", Arrays.asList(1, "$lineitems.discount"));
 Document multiplyDisc = new Document("$multiply", Arrays.asList("$lineitems.extendedPrice", subtractDisc));

ordersCollection.aggregate(
                Arrays.asList(
                        Aggregates.unwind("$lineitems"),
                        Aggregates.match(Filters.lte("lineitems.shipdate", 10)),
                        Aggregates.group(groupFields,
                                Accumulators.sum("sum_qty", "$lineitems.quantity"),
                                Accumulators.sum("sum_base_price", "$lineitems.extendedPrice"),
                                Accumulators.sum("sum_disc_price", multiplyDisc)
                          )
                        )
  ).forEach(printBlock);