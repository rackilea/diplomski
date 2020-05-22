DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
    Map<String, ExpectedAttributeValue> expectedAttributes =
        ImmutableMap.<String, ExpectedAttributeValue>builder()
            .put(THREAD_ID, new ExpectedAttributeValue().withExists(false)) //The threadId doesn't exist or is empty
            .build();
    saveExpression.setExpected(expectedAttributes);