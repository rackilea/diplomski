DistinctIterable<String> iterable = mongoClient.getDatabase(dbName).
            .getCollection(collectionName, TDocType.class).distinct(NAME_KEY, String.class);
MongoCursor<String> cursor = iterable.iterator();
List<String> list = new ArrayList<>();
while (cursor.hasNext()) {
    list.add(cursor.next());
 }