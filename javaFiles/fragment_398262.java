UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("yearkey", yearKey, "title", title)
        .withReturnValues(ReturnValue.UPDATED_NEW).withUpdateExpression("set #createdate = :val1")
        .withNameMap(new NameMap().with("#createdate", "createdate"))
        .withValueMap(new ValueMap().withString(":val1", createDate))
        .withConditionExpression("createdate < :val1");

UpdateItemOutcome outcome = null;
try {
    outcome = table.updateItem(updateItemSpec); 
} catch (ConditionalCheckFailedException ce) {
    System.out.println("Conditional check failed." + ce.getMessage());
    return false;
}

return true;