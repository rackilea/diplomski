StringJoiner filterExpression = new StringJoiner(" AND ");
Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
int itemAttributeSuffix = 0;
for (String itemString : items) {
    StringBuilder expression = new StringBuilder("#idname")
            .append(" ")
            .append("<>")
            .append(" ")
            .append(":idval")
            .append(itemAttributeSuffix);
    filterExpression.add(expression);
    expressionAttributeValues.put(":idval" + itemAttributeSuffix++,
        new AttributeValue().withS(itemString));
}
Map<String, String> expressionAttributeNames = Collections.singletonMap("#idname", "id");
scanExpression.setFilterExpression(filterExpression.toString());
scanExpression.setExpressionAttributeNames(expressionAttributeNames);
scanExpression.setExpressionAttributeValues(expressionAttributeValues);

PaginatedScanList<Items> result = mapper.scan(Item.class, scanExpression);