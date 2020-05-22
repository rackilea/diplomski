public List<ProductDO> get(List<Filter> filters, String previousPageLastKey, int count) {

    FilterExpression filterExpression = new FilterExpression(filters);
    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
            .withLimit(count)
            .withFilterExpression(filterExpression.getFilterExpression())
            .withExpressionAttributeNames(filterExpression.getAttributeNames())
            .withExpressionAttributeValues(filterExpression.getAttributeValues());

    dynamoDBMapper.scan(ProductDO.class, scanExpression)
}