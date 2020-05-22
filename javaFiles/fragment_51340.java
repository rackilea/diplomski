Aggregation meanAggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where(IndicesUtil.INDICES_ID).is(indicesId)),
            Aggregation.unwind(IndicesUtil.PREFIX+IndicesUtil.DATA_SETS),
            Aggregation.match(Criteria.where(IndicesUtil.DATA_SETS_DATE).gte(startDate).lte(indicesDataSet.getDate())),
            Aggregation.group(IndicesUtil.INDICES_ID).avg(averageParameter).as(IndicesUtil.MEAN).push("$$ROOT").as("indices"),
            Aggregation.unwind(IndicesUtil.PREFIX+IndicesUtil.INDICES),
            Aggregation.project("_id", "mean").andExpression("(indices.dataSets.data - mean) * (indices.dataSets.data - mean)").as("firstResult"),
            Aggregation.group().avg("$firstResult").as("secondResult").first(IndicesUtil.PREFIX+IndicesUtil.MEAN).as(IndicesUtil.MEAN),
            Aggregation.project("mean").and("secondResult").sqrt().as(IndicesUtil.DATA)
 );