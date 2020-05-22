Aggregation aggregation = newAggregation(
            match(Criteria.where("devices.evaluationDate").is(date)),
            project().and(new AggregationExpression() {
                @Override
                public DBObject toDbObject(AggregationOperationContext aggregationOperationContext) {
                    DBObject filterExpression = new BasicDBObject();
                    filterExpression.put("input", "$devices");
                    filterExpression.put("as", "device");
                    filterExpression.put("cond", new BasicDBObject("$eq", Arrays.<Object> asList("$$device.evaluationDate", date)));
                    return new BasicDBObject("$filter", filterExpression);
                }
            }).as("devices")
    );

    AggregationResults<SpotMovimientos> list = mongoOperations.aggregate(aggregation,
            MyClass.class, MyClass.class);