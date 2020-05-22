QuerySpec querySpec = new QuerySpec();
querySpec.withKeyConditionExpression("yearkey = :yearval and title = :title")
                .withFilterExpression("contains (subscriptions, :subscriptions)")
                .withValueMap(
                        new ValueMap().withNumber(":yearval", yearKey)
                        .withString(":title", title) 
                        .withString(":subscriptions", subscriptions));