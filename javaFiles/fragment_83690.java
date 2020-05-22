ItemCollection<QueryOutcome> items = null;

        QuerySpec querySpec = new QuerySpec();

        ValueMap valueMap = new ValueMap();
        valueMap.withString(":autoIdVal", autoID);
        valueMap.withString(":docTypeVal", docType);
        valueMap.withString(":username", username);
        valueMap.withString(":comment", comment);

        Map<String, String> nameMap = new LinkedHashMap<>();
        nameMap.put("#comment", "comment");

        querySpec.withKeyConditionExpression("autoID = :autoIdVal").withFilterExpression("(docType = :docTypeVal AND username = :username) OR (#comment = :comment)")
                .withValueMap(valueMap)
                .withNameMap(nameMap);

        items = table.query(querySpec);

        Iterator<Item> iterator = items.iterator();

        Item itemData = null;

        while (iterator.hasNext()) {
            itemData = iterator.next();

            System.out.println("Json data ====================>" + itemData.toJSONPretty());

        }