ArrayList<Object> objects = new ArrayList<Object>();

    MongoCursor<Document> iterator = coll.aggregate(Arrays.asList(
            new Document("$group",
                    new Document("_id", "$tenantId")
            )
    )).iterator();

    while (iterator.hasNext()) {
        objects.add(iterator.next().get("_id"));
    }

    System.out.println(objects);