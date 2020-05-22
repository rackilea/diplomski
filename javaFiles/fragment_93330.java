Table table = dynamoDB.getTable(tableName);

String hashKey = "<YOUR_COMPUTED_HASH_KEY>";
String timestampX = "<YOUR_TIMESTAMP_X_VALUE>";
String timestampY = "<YOUR_TIMESTAMP_Y_VALUE>";

RangeKeyCondition rangeKeyCondition = new RangeKeyCondition("RangeKeyAttributeName").between(timestampX, timestampY);

        ItemCollection<QueryOutcome> items = table.query("HashKeyAttributeName", hashKey,
            rangeKeyCondition,
            null, //FilterExpression - not used in this example
            null,  //ProjectionExpression - not used in this example
            null, //ExpressionAttributeNames - not used in this example
            null); //ExpressionAttributeValues - not used in this example