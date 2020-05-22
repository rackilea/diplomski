QuerySpec spec = new QuerySpec().withKeyConditionExpression("Id = :v_id")
            .withValueMap(new ValueMap().withString(":v_id", replyId)).withMaxPageSize(1);

        ItemCollection<QueryOutcome> items = table.query(spec);

        System.out.println("\nfindRepliesForAThreadSpecifyOptionalLimit results:");

        // Process each page of results
        int pageNum = 0;
        for (Page<Item, QueryOutcome> page : items.pages()) {

if(page.size==0)   ](fix )
break;             ]
            System.out.println("\nPage: " + ++pageNum);

            // Process each item on the current page
            Iterator<Item> item = page.iterator();
            while (item.hasNext()) {
                System.out.println(item.next().toJSONPretty());
            }
        }
    }