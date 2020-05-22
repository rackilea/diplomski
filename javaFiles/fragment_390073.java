Aggregation aggregation = newAggregation(
            match(Criteria.where(FIELDS.HOTEL_ID).is(hotelId).and(FIELDS.SESSSION_ID).is(uniqueId)),
            group(FIELDS.DATE,FIELDS.SERVICE_OR_FACILITY).sum(FIELDS.ORDER_TOTAL).as(FIELDS.ORDER_TOTAL).sum(FIELDS.ADJUSTMENT)
                    .as(FIELDS.ADJUSTMENT).sum(FIELDS.DISCOUNT).as(FIELDS.DISCOUNT).sum(FIELDS.GRAND_TOTAL)
                    .as(FIELDS.GRAND_TOTAL),
            sort(Sort.Direction.ASC, previousOperation(),FIELDS.DATE,FIELDS.SERVICE_OR_FACILITY));
    AggregationResults<RevenueReportsTemporaryStorage> groupResults = mongoTemplate.aggregate(aggregation,
            RevenueReportsTemporaryStorage.class, RevenueReportsTemporaryStorage.class);
    return groupResults.getMappedResults();